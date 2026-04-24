package com.webhook.chatbot.service;

import com.webhook.chatbot.dto.WebhookRequest;
import com.webhook.chatbot.dto.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ChatbotService {

    private final List<String> messageLog = new ArrayList<>();

    public WebhookResponse handleMessage(WebhookRequest request) {
        String incoming = request.getMessage();
        String sender = request.getFrom();

        log.info("Received from [{}]: {}", sender, incoming);
        messageLog.add("From: " + sender + " | Message: " + incoming);

        String reply = generateReply(incoming);
        return new WebhookResponse(sender, reply);
    }

    private String generateReply(String message) {
        if (message == null) return "Sorry, I didn't get that.";
        return switch (message.trim().toLowerCase()) {
            case "hi", "hello", "hey" -> "Hello";
            case "bye", "goodbye"     -> "Goodbye";
            default                   -> "Sorry, I only understand Hi and Bye for now.";
        };
    }

    public List<String> getLogs() {
        return messageLog;
    }
}