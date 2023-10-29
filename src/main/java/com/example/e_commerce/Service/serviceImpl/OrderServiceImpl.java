package com.example.e_commerce.Service.serviceImpl;

import com.example.e_commerce.Model.Cart;
import com.example.e_commerce.Model.Orders;
import com.example.e_commerce.Model.Users;
import com.example.e_commerce.Repo.CartRepo;
import com.example.e_commerce.Repo.OrderRepo;
import com.example.e_commerce.Repo.UserRepo;
import com.example.e_commerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepository;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private CartRepo cartRepository;

    @Override
    public void deleteOrder(Long orderId) {
    orderRepository.deleteById(orderId);
    }

    @Override
    public String addOrder(Long userId,Orders order) {
       Users user= userRepository.findById(userId).orElseThrow();
         order.setUser(user);
         Cart cart = cartRepository.findById(user.getCart().getId()).orElseThrow();
            orderRepository.save(order);
            return "Order added successfully";

    }

    @Override
    public String updateOrder(Long orderId, Orders order) {
        Orders order1 = orderRepository.findById(orderId).orElseThrow();
        order1.setOrderDetails(order.getOrderDetails());
        order1.setOrderDate(order.getOrderDate());
        order1.setOrderNumber(order.getOrderNumber());
        order1.setTotalAmount(order.getTotalAmount());
        order1.setUser(order.getUser());
        orderRepository.save(order1);
        return "Order updated successfully";
    }

    @Override
    public List<Orders> getOrderByUserId(Long userId) {
       Users users= userRepository.findById(userId).orElseThrow();
       return users.getOrders();
    }



    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public String getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow().toString();
    }
}
