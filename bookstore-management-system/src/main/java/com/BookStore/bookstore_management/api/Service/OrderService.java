package com.BookStore.bookstore_management.api.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.bookstore_management.api.DTOs.OrderItemRequest;
import com.BookStore.bookstore_management.api.DTOs.PlaceOrderRequest;
import com.BookStore.bookstore_management.api.Model.BookStore;
import com.BookStore.bookstore_management.api.Model.Order;
import com.BookStore.bookstore_management.api.Model.OrderItem;
import com.BookStore.bookstore_management.api.Model.User;
import com.BookStore.bookstore_management.api.Repository.BookstoreRepository;
import com.BookStore.bookstore_management.api.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookstoreRepository bookstoreRepository;

    public Order placeOrder(User user, PlaceOrderRequest req) {
        // Implementation for placing an order
        Order order = new Order();
        order.setUserId(user.getId());
        order.setCustomerEmail(user.getEmail());
        order.setCustomerName(user.getName());
        order.setStatus("PENDING");
        order.setPaymentStatus("PAID");
        order.setOrderDate(new Date());

        List<OrderItem> orderItems = new ArrayList<>();
        double totalAmount = 0.0;

        for (OrderItemRequest itemReq : req.getItems()) {
            BookStore book = bookstoreRepository.findById(itemReq.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found"));

            OrderItem orderItem = new OrderItem(
                    book.getId(),
                    book.getBook_title(),
                    itemReq.getQuantity(),
                    book.getPrice() * itemReq.getQuantity());
            totalAmount += orderItem.getPrice();
            orderItems.add(orderItem);
        }
        order.setItems(orderItems);
        order.setTotalAmount(totalAmount);

        return orderRepository.save(order); // Placeholder return
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order updatOrderStatus(String orderId, String status) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }

}
