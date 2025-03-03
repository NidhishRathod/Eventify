package com.example.PaymentService.controller;

import com.example.PaymentService.entity.Payment;
import com.example.PaymentService.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<?> processPayment(@RequestParam String userId,
                                            @RequestParam String paymentType,
                                            @RequestParam BigDecimal amount,
                                            @RequestParam String currency) {
        try {
            Payment payment = paymentService.processPayment(userId, paymentType, amount, currency);
            return ResponseEntity.ok(payment);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payment>> getUserPayments(@PathVariable String userId) {
        return ResponseEntity.ok(paymentService.getUserPayments(userId));
    }
}
