package com.dkds.payment_processor.payment_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime createdAt = LocalDateTime.now();
}
