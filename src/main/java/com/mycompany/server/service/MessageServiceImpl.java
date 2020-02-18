package com.mycompany.server.service;

import com.mycompany.server.messaging.MessageReceiver;
import com.mycompany.server.messaging.MessageSender;
import com.mycompany.server.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

@Service("employeeService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageSender messageSender;
    @Autowired
    private MessageReceiver receiver;


    public MessageServiceImpl() {
    }


    @Override
    public String sendMessage(String message) {
        messageSender.sendMessage(message);
        return JsonUtils.getMessageId(message);
    }

    @Override
    public String getMessage(String uuid) throws InterruptedException, ExecutionException, NoSuchElementException {
        return receiver.getResponse(uuid);
    }
}
