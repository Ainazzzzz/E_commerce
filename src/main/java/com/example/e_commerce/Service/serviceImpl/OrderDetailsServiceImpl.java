package com.example.e_commerce.Service.serviceImpl;

import com.example.e_commerce.Model.*;
import com.example.e_commerce.Repo.*;
import com.example.e_commerce.Service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailsRepo orderDetailsRepository;
    @Autowired
    private OrderRepo orderRepository;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ProductRepo productRepository;


    @Override
    public void deleteOrderDetails(Long orderDetailsId) {
        orderDetailsRepository.deleteById(orderDetailsId);

    }

    @Override
    public String addOrderDetails(long orderId, OrdersDetails orderDetails) {
       Orders order= orderRepository.findById(orderId).orElseThrow();
         orderDetails.setOrder(order);
         orderDetails.setItemPrice(orderDetails.getProduct().getPrice());
        CartItem cartItem = CartItem.builder()
                .quantity(orderDetails.getQuantity())
                .product(orderDetails.getProduct())
                .cart(orderDetails.getOrder().getUser().getCart())
                .pricePerItem(orderDetails.getProduct().getPrice())
                .build();
             orderDetails.setCartItem(cartItem);
            orderDetailsRepository.save(orderDetails);
            return "OrderDetails added successfully";

    }

    @Override
    public String updateOrderDetails(Long orderDetailsId, OrdersDetails orderDetails) {
        OrdersDetails orderDetails1 = orderDetailsRepository.findById(orderDetailsId).orElseThrow();
        orderDetails1.setQuantity(orderDetails.getQuantity());
        orderDetails1.setProduct(orderDetails.getProduct());
        orderDetails1.setOrder(orderDetails.getOrder());
        orderDetails1.setCartItem(orderDetails.getCartItem());
        orderDetailsRepository.save(orderDetails1);
        return "OrderDetails updated successfully";

    }

    @Override
    public List<OrdersDetails> getOrderDetailsByUserId(Long userId) {
        Users users= userRepository.findById(userId).orElseThrow();
        List<OrdersDetails> ordersDetails = new ArrayList<>();
        for (Orders order:users.getOrders()) {
            ordersDetails.add(order.getOrderDetails());

        }
        return ordersDetails;
    }

    @Override
    public OrdersDetails getOrderDetailsById(Long orderDetailsId) {
        return orderDetailsRepository.findById(orderDetailsId).orElseThrow();
    }

    @Override
    public List<OrdersDetails> getOrderDetailsByProductId(Long productId) {
    Product product = productRepository.findById(productId).orElseThrow();
    List<OrdersDetails> ordersDetails = new ArrayList<>();
    for (OrdersDetails orderDetails:orderDetailsRepository.findAll()) {
        if (orderDetails.getProduct().equals(product)){
            ordersDetails.add(orderDetails);
        }
    }
return ordersDetails;
    }
}
