package br.com.chatmessage.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class ChatMessageReceiver {
    private final List<String> messages = new ArrayList<>();

    @RabbitListener(queues = "chat-queue")
    public void sendEmail(String message) throws MessagingException {
        messages.add(message);
    }
}