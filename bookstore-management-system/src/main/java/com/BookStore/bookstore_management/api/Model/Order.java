package com.BookStore.bookstore_management.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String userId; // Reference to User
    private String customerName;
    private String customerEmail;

    private List<OrderItem> items;

    private double totalAmount;

    private String status; // PENDING, SHIPPED, DELIVERED
    private String paymentStatus; // PAID / PENDING

    private Date orderDate;

    // getters and setters
}
