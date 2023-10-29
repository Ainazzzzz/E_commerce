package com.example.e_commerce.Service;

import com.example.e_commerce.Model.OrdersDetails;

import java.util.List;

public interface OrderDetailsService {
    void deleteOrderDetails(Long orderDetailsId);
    String addOrderDetails(long orderId,OrdersDetails orderDetails);
    String updateOrderDetails(Long orderDetailsId,OrdersDetails orderDetails);
    List<OrdersDetails> getOrderDetailsByUserId(Long userId);
    OrdersDetails getOrderDetailsById(Long orderDetailsId);
    List<OrdersDetails> getOrderDetailsByProductId(Long productId);

}
