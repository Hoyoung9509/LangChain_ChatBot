package com.fastcampus.langchain_chatbot.controller;

import com.fastcampus.langchain_chatbot.dto.ChatRequest;
import com.fastcampus.langchain_chatbot.dto.ChatResponse;
import com.fastcampus.langchain_chatbot.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        // 예외는 GlobalExceptionHandler에서 처리됩니다.
        ChatResponse response = chatService.sendQuestion(request.getQuestion());
        return ResponseEntity.ok(response);
    }
}
