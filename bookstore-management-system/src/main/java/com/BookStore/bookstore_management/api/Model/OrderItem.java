package com.BookStore.bookstore_management.api.Model;

import lombok.Data;

@Data
public class OrderItem {

    private String bookId;
    private String bookTitle;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(String bookId, String bookTitle, int quantity, double price) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.price = price;
    }
}
