package com.fastcampus.langchain_chatbot.service;

import com.fastcampus.langchain_chatbot.dto.ChatRequest;
import com.fastcampus.langchain_chatbot.dto.ChatResponse;
import com.fastcampus.langchain_chatbot.exception.ChatbotException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {

    private final RestTemplate restTemplate;
    private final String fastApiUrl;

    public ChatService(RestTemplate restTemplate, @Value("${fastapi.url:http://localhost:8000/ask}") String fastApiUrl) {
        this.restTemplate = restTemplate;
        this.fastApiUrl = fastApiUrl;
    }

    public ChatResponse sendQuestion(String question) {
        try {
            ChatRequest request = new ChatRequest(question);
            ResponseEntity<ChatResponse> response = restTemplate.postForEntity(fastApiUrl, request, ChatResponse.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return response.getBody();
            } else {
                throw new ChatbotException("Failed to get response from FastAPI server: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new ChatbotException("Error communicating with FastAPI server: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new ChatbotException("Unexpected error: " + e.getMessage(), e);
        }
    }
}
