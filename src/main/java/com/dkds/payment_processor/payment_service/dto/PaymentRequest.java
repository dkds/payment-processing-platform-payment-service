package com.dkds.payment_processor.payment_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private String transactionId;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be greater than 0")
    private Double amount;

    @NotBlank(message = "Currency is required")
    private String currency;

    @NotBlank(message = "Recipient ID is required")
    private String recipientId;

    private String description;
}
