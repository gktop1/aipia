package com.example.aipia.order.service;

import com.example.aipia.common.exception.CustomException;
import com.example.aipia.member.model.MemberEntity;
import com.example.aipia.order.dto.OrderRegisterRequest;
import com.example.aipia.order.model.OrderEntity;
import com.example.aipia.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void requestOrder(OrderRegisterRequest orderRegisterRequest, MemberEntity member) {
        OrderEntity orderEntity = new OrderEntity(orderRegisterRequest, member);
        orderRepository.save(orderEntity);
    }

    @Transactional
    public OrderEntity getOrderEntity(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new CustomException("존재 하지 않는 주문번호입니다."));
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new CustomException("존재 하지 않는 주문번호입니다."));
        order.cancelOrder();
    }

    @Transactional
    public void progressOrder(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new CustomException("존재 하지 않는 주문번호입니다."));
        order.progressOrder();
    }

    @Transactional
    public void completeOrder(Long orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow(() -> new CustomException("존재 하지 않는 주문번호입니다."));
        order.completeOrder();
    }
}
