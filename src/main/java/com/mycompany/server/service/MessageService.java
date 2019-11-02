package com.mycompany.server.service;

import java.util.concurrent.ExecutionException;

public interface MessageService {
     String sendMessage(String message);

     String getMessage(String uuid) throws InterruptedException, ExecutionException;

}
