package com.example.PaymentService.service;

import com.example.PaymentService.client.UserClient;
import com.example.PaymentService.entity.Payment;
import com.example.PaymentService.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserClient userClient;

    public PaymentService(PaymentRepository paymentRepository, UserClient userClient) {
        this.paymentRepository = paymentRepository;
        this.userClient = userClient;
    }

    public Payment processPayment(String userId, String paymentType, BigDecimal amount, String currency) {
        if (!userClient.doesUserExist(Long.valueOf(userId))) {
            throw new RuntimeException("User does not exist! Payment failed.");
        }

        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setPaymentType(paymentType);
        payment.setAmount(amount);
        payment.setCurrency(currency);
        payment.setStatus("PENDING");

        if (amount.compareTo(new BigDecimal("10000")) > 0) {
            payment.setStatus("FAILED"); // Simple fraud detection
        } else {
            payment.setStatus("SUCCESS");
        }

        return paymentRepository.save(payment);
    }

    public List<Payment> getUserPayments(String userId) {
        return paymentRepository.findByUserId(userId);
    }
}
