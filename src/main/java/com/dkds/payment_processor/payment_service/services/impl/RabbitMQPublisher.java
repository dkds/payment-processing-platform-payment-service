package com.dkds.payment_processor.payment_service.services.impl;

import com.dkds.payment_processor.payment_service.entities.Payment;
import com.dkds.payment_processor.payment_service.services.MessagePublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher implements MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "payment.exchange";

    @Override
    public void publishPaymentStatus(Payment payment) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "payment.status", payment);
    }
}
