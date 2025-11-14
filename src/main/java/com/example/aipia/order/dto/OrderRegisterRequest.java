package com.example.aipia.order.dto;

import java.math.BigDecimal;

public record OrderRegisterRequest(Long memberId, BigDecimal amount) {
}
