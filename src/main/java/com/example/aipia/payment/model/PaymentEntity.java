package com.example.aipia.payment.model;


import com.example.aipia.common.BaseEntity;
import com.example.aipia.order.model.OrderEntity;
import com.example.aipia.payment.dto.PaymentRegisterRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "payment")
@NoArgsConstructor
public class PaymentEntity extends BaseEntity {

    @Column(name = "amount")
    private BigDecimal amount;

    @JoinColumn(name = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity order;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    public PaymentEntity(PaymentRegisterRequest request, OrderEntity order) {
        this.order = order;
        this.amount = request.amount();
        this.status = PaymentStatus.progress;
    }

    public void cancelPayment() {
        this.status = PaymentStatus.cancel;
    }

    public void completePayment() {
        this.status = PaymentStatus.complete;
    }
}
