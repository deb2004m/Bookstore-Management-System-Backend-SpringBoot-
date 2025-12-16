package com.BookStore.bookstore_management.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/health")
public class healthcheack {
    @GetMapping("/check")
    public String checkHealth() {
        return "API is running fine";
    }

}
