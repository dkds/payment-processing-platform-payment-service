package com.dkds.payment_processor.payment_service.controllers;

import com.dkds.payment_processor.payment_service.dto.PaymentRequest;
import com.dkds.payment_processor.payment_service.entities.Payment;
import com.dkds.payment_processor.payment_service.services.PaymentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<String> initiatePayment(@Valid @RequestBody PaymentRequest request) {
        paymentService.initiatePayment(request);
        return ResponseEntity.ok("Payment request received and is being processed asynchronously.");
    }

    @PostMapping
    public ResponseEntity<Payment> processPayment(
            @RequestParam Long userId,
            @RequestParam Double amount) {
        Payment payment = paymentService.processPayment(userId, amount);
        return ResponseEntity.ok(payment);
    }
}
