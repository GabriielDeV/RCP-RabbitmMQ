package com.exemplo.rpc.rabbitmq.client;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.exemplo.rpc.rabbitmq.config.RabbitMQConfig;

import java.util.UUID;

@Component
public class FibonacciRpcClient {

    private final RabbitTemplate rabbitTemplate;

    public FibonacciRpcClient(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String call(String message) {
        String correlationId = UUID.randomUUID().toString();
        MessageProperties props = new MessageProperties();
        props.setCorrelationId(correlationId);

        Message request = new Message((message + " - Gabriel Xavier Cabraç").getBytes(), props);
        
        Message response = rabbitTemplate.sendAndReceive(RabbitMQConfig.RPC_QUEUE_NAME, request);

        return new String(response.getBody());
    }
}