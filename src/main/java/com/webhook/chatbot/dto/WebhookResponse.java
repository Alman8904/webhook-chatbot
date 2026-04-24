package com.webhook.chatbot.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class WebhookResponse {
    private String to;
    private String reply;
}