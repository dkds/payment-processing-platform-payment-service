package com.dkds.payment_processor.payment_service.services.impl;

import com.dkds.payment_processor.payment_service.entities.Payment;
import com.dkds.payment_processor.payment_service.entities.PaymentStatus;
import com.dkds.payment_processor.payment_service.repositories.PaymentRepository;
import com.dkds.payment_processor.payment_service.services.MessagePublisher;
import com.dkds.payment_processor.payment_service.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringDataPaymentService implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private MessagePublisher messagePublisher;

    @Override
    public Payment processPayment(Long userId, Double amount) {
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAmount(amount);
        payment.setStatus(PaymentStatus.PENDING);

        Payment savedPayment = paymentRepository.save(payment);

        // Simulate external API call
        boolean isSuccess = externalPaymentGatewayIntegration(amount);
        savedPayment.setStatus(isSuccess ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        paymentRepository.save(savedPayment);

        // Publish payment status
        messagePublisher.publishPaymentStatus(savedPayment);

        return savedPayment;
    }

    private boolean externalPaymentGatewayIntegration(Double amount) {
        // Simulate success for amounts <= 100
        return amount <= 100.0;
    }
}
