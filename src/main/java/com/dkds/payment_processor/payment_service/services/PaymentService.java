package com.dkds.payment_processor.payment_service.services;

import com.dkds.payment_processor.payment_service.dto.PaymentRequest;
import com.dkds.payment_processor.payment_service.entities.Payment;
import jakarta.validation.Valid;

public interface PaymentService {
    Payment processPayment(Long userId, Double amount);

    void initiatePayment(@Valid PaymentRequest request);
}
