package com.dkds.payment_processor.payment_service.controllers;

import com.dkds.payment_processor.payment_service.entities.Payment;
import com.dkds.payment_processor.payment_service.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> processPayment(
            @RequestParam Long userId,
            @RequestParam Double amount) {
        Payment payment = paymentService.processPayment(userId, amount);
        return ResponseEntity.ok(payment);
    }
}
