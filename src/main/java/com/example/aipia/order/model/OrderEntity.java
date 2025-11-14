package com.example.aipia.order.model;


import com.example.aipia.common.BaseEntity;
import com.example.aipia.member.model.MemberEntity;
import com.example.aipia.order.dto.OrderRegisterRequest;
import com.example.aipia.payment.model.PaymentEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class OrderEntity extends BaseEntity {

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity member;

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<PaymentEntity> paymentList;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public OrderEntity(OrderRegisterRequest request, MemberEntity member) {
        this.member = member;
        this.amount = request.amount();
        this.status = OrderStatus.request;
    }

    public void progressOrder() {
        this.status = OrderStatus.progress;
    }

    public void cancelOrder() {
        this.status = OrderStatus.cancel;
    }

    public void completeOrder() {
        this.status = OrderStatus.complete;
    }


}
