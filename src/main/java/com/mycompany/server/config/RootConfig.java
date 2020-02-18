package com.mycompany.server.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author imssbora
 */
@Configuration
public class RootConfig {
    @Bean
    public BlockingQueue<String> sharedQueue() {
        return new LinkedBlockingQueue<>();
    }

    @Bean
    public Map<String, String> messageMap() {
        return new ConcurrentHashMap<>();
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
