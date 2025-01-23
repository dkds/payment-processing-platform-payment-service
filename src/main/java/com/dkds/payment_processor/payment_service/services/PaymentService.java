package com.dkds.payment_processor.payment_service.services;

import com.dkds.payment_processor.payment_service.entities.Payment;

public interface PaymentService {
    Payment processPayment(Long userId, Double amount);
}
