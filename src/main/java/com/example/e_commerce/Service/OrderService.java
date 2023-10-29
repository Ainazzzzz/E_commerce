package com.example.e_commerce.Service;

import com.example.e_commerce.Model.Orders;

import java.util.List;

public interface OrderService {
    void deleteOrder(Long orderId);
    String addOrder(Long userId,Orders order);
    String updateOrder(Long orderId, Orders order);
    List<Orders> getOrderByUserId(Long userId);
    List<Orders> getAllOrders();
    String getOrderById(Long orderId);

}
