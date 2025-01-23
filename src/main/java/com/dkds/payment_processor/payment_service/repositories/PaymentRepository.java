package com.dkds.payment_processor.payment_service.repositories;

import com.dkds.payment_processor.payment_service.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
