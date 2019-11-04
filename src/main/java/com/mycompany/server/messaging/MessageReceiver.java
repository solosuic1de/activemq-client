package com.mycompany.server.messaging;

import com.mycompany.server.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.*;

@Component
public class MessageReceiver {
    static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    private static final String ORDER_RESPONSE_QUEUE = "client.queue";
    @Autowired
    Map<String, String> map;

    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(String message) throws InterruptedException {
        map.put(JsonUtils.getMessageId(message), message);
    }

    public String getResponse(String uuid) throws InterruptedException, ExecutionException, NoSuchElementException {
        Callable<String> task = () -> {
            String result = map.remove(uuid);
            int spentTime = 0;
            while (result == null) {
                if (spentTime == 300)
                    throw new TimeoutException("server not response");
                TimeUnit.MILLISECONDS.sleep(100);
                result = map.remove(uuid);
                spentTime++;
            }
            return result;
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(task);
        return JsonUtils.getMessageResponse(future.get());
    }
}
