package com.example.e_commerce.Service.serviceImpl;

import com.example.e_commerce.Repo.PaymentRepo;
import com.example.e_commerce.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepository;

    @Override
    public String addPayment(Long userId, Long orderId, String paymentMethod, String paymentStatus, String paymentDate) {
        return null;
    }

    @Override
    public String deletePayment(Long paymentId) {
        return null;
    }

    @Override
    public String updatePayment(Long paymentId, String paymentMethod, String paymentStatus, String paymentDate) {
        return null;
    }

    @Override
    public String getPaymentByUserId(Long userId) {
        return null;
    }

    @Override
    public String getPaymentByOrderId(Long orderId) {
        return null;
    }

    @Override
    public String getPaymentById(Long paymentId) {
        return null;
    }

    @Override
    public String getAllPayments() {
        return null;
    }
}
