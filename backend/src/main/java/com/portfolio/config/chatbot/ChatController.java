package com.example.chatbotfeature.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    // Simple hardcoded responses for the chatbot
    private String getChatbotResponse(String userMessage) {
        switch (userMessage.toLowerCase()) {
            case "hello":
                return "Hi! How can I help you today?";
            case "how are you":
                return "I'm doing great, thanks for asking!";
            case "bye":
                return "Goodbye! Take care.";
            default:
                return "Sorry, I didn't understand that.";
        }
    }

    // POST endpoint to handle chatbot messages
    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) {
        String userMessage = chatRequest.getMessage();
        String botResponse = getChatbotResponse(userMessage);
        return new ChatResponse(botResponse);
    }
}
