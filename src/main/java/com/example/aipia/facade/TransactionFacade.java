package com.example.aipia.facade;

import com.example.aipia.member.model.MemberEntity;
import com.example.aipia.member.service.MemberService;
import com.example.aipia.order.dto.OrderRegisterRequest;
import com.example.aipia.order.model.OrderEntity;
import com.example.aipia.order.service.OrderService;
import com.example.aipia.payment.dto.PaymentRegisterRequest;
import com.example.aipia.payment.model.PaymentEntity;
import com.example.aipia.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionFacade {

    private final MemberService memberService;
    private final OrderService orderService;
    private final PaymentService paymentService;

    @Transactional
    public void requestOrder(OrderRegisterRequest request) {

        MemberEntity member = memberService.getMemberEntity(request.memberId());
        orderService.requestOrder(request, member);

    }

    @Transactional
    public void requestPayment(PaymentRegisterRequest request) {
        OrderEntity order = orderService.getOrderEntity(request.orderId());

        paymentService.requestPayment(request, order);
        orderService.progressOrder(order.getId());
    }

    @Transactional
    public void completePayment(Long paymentId) {
        PaymentEntity payment = paymentService.getPayment(paymentId);
        payment.completePayment();
        orderService.completeOrder(payment.getOrder().getId());
    }
}
