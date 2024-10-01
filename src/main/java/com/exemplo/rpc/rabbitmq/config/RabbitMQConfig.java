package com.exemplo.rpc.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String RPC_QUEUE_NAME = "rpc_queue";

    @Bean
    public Queue rpcQueue() {
        return new Queue(RPC_QUEUE_NAME);
    }
}