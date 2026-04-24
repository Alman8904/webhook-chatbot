package com.webhook.chatbot.controller;

import com.webhook.chatbot.dto.WebhookRequest;
import com.webhook.chatbot.dto.WebhookResponse;
import com.webhook.chatbot.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebhookController {

    private final ChatbotService chatbotService;

    @GetMapping("/")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Chatbot is running!");
    }

    @PostMapping("/webhook")
    public ResponseEntity<WebhookResponse> receiveMessage(@RequestBody WebhookRequest request) {
        WebhookResponse response = chatbotService.handleMessage(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/logs")
    public ResponseEntity<List<String>> getLogs() {
        return ResponseEntity.ok(chatbotService.getLogs());
    }
}