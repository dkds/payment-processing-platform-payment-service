package com.dkds.payment_processor.payment_service.services.impl;

import com.dkds.payment_processor.payment_service.entities.Payment;
import com.dkds.payment_processor.payment_service.services.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisher implements MessagePublisher {

    private static final String TOPIC_NAME = "payment_status";
    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    @Override
    public void publishPaymentStatus(Payment payment) {
        kafkaTemplate.send(TOPIC_NAME, payment);
    }
}
