package com.fastcampus.langchain_chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SimpleController {

    @GetMapping("/home")
    @ResponseBody
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World!");
        return response;
    }

    @GetMapping("/chat")
    public String chatPage() {
        return "redirect:/chat.html";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/chat";
    }
}
