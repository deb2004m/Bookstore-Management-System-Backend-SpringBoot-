package com.BookStore.bookstore_management.api.DTOs;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

}
