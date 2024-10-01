package com.exemplo.rpc.rabbitmq.server;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FibonacciRpcServer {

    @RabbitListener(queues = "rpc_queue")
    public String process(Message message) {
        String receivedMessage = new String(message.getBody());
        System.out.println("[.] Recebido: " + receivedMessage); 
        
        String[] parts = receivedMessage.split(" ");
        int n = Integer.parseInt(parts[0]);
        return String.valueOf(fib(n));
    }

    private int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}