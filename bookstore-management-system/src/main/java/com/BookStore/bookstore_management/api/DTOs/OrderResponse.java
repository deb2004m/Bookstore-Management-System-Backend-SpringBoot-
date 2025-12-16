package com.BookStore.bookstore_management.api.DTOs;

import java.util.List;

import com.BookStore.bookstore_management.api.Model.OrderItem;

import lombok.Data;

@Data
public class OrderResponse {
    private String orderId;
    private String customerName;
    private String customerEmail;
    private List<OrderItem> items;
    private double totalAmount;
    private String status;
    private String paymentStatus;

}
