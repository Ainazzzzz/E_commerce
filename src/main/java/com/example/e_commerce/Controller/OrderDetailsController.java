package com.example.e_commerce.Controller;

import com.example.e_commerce.Model.OrdersDetails;
import com.example.e_commerce.Service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/orderDetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @DeleteMapping("/{orderDetailsId}")
    public void deleteOrderDetails(@PathVariable Long orderDetailsId) {
        orderDetailsService.deleteOrderDetails(orderDetailsId);
    }

    @PostMapping
    public ResponseEntity<String> addOrderDetails(
            @RequestParam long orderId, @RequestBody OrdersDetails orderDetails) {
        String result = orderDetailsService.addOrderDetails(orderId, orderDetails);
        if (result != null) {
            return ResponseEntity.status(201).body("Order details added with ID: " + result);
        } else {
            return ResponseEntity.badRequest().body("Failed to add order details");
        }
    }

    @PutMapping("/{orderDetailsId}")
    public String updateOrderDetails(
            @PathVariable Long orderDetailsId, @RequestBody OrdersDetails orderDetails) {
        return orderDetailsService.updateOrderDetails(orderDetailsId, orderDetails);
    }

    @GetMapping("/user/{userId}")
    public List<OrdersDetails> getOrderDetailsByUserId(@PathVariable Long userId) {
        return orderDetailsService.getOrderDetailsByUserId(userId);
    }

    @GetMapping("/{orderDetailsId}")
    public OrdersDetails getOrderDetailsById(@PathVariable Long orderDetailsId) {
        return orderDetailsService.getOrderDetailsById(orderDetailsId);
    }

    @GetMapping("/product/{productId}")
    public List<OrdersDetails> getOrderDetailsByProductId(@PathVariable Long productId) {
        return orderDetailsService.getOrderDetailsByProductId(productId);
    }
}
