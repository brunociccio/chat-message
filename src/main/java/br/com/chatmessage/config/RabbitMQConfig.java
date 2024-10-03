package br.com.chatmessage.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {
    public static final String CHAT_QUEUE = "chat-queue";

    @Bean
    public Queue chatQueue() {
        return new Queue(CHAT_QUEUE, false);
    }
}
