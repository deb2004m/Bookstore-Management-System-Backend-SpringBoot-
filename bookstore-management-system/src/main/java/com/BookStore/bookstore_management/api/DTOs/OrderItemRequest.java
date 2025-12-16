package com.BookStore.bookstore_management.api.DTOs;

import lombok.Data;

@Data
public class OrderItemRequest {
    private String bookId;
    private int quantity;

}
