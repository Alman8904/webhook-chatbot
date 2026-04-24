package com.webhook.chatbot.dto;

import lombok.Data;

@Data
public class WebhookRequest {
    private String from;
    private String message;
}