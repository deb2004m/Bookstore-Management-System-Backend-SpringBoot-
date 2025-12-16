package com.BookStore.bookstore_management.api.DTOs;

import java.util.List;

import lombok.Data;

@Data
public class PlaceOrderRequest {
    private List<OrderItemRequest> Items;

}
