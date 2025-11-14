package com.example.aipia.payment.dto;

import java.math.BigDecimal;

public record PaymentRegisterRequest(Long orderId, BigDecimal amount) {
}
