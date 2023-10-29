package com.example.e_commerce.Service;

public interface PaymentService {
    String addPayment(Long userId, Long orderId, String paymentMethod, String paymentStatus, String paymentDate);
    String deletePayment(Long paymentId);
    String updatePayment(Long paymentId, String paymentMethod, String paymentStatus, String paymentDate);
    String getPaymentByUserId(Long userId);
    String getPaymentByOrderId(Long orderId);
    String getPaymentById(Long paymentId);
    String getAllPayments();
}
