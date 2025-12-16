package com.BookStore.bookstore_management.api.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.BookStore.bookstore_management.api.Model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);

}
