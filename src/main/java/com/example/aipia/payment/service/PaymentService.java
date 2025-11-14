package com.example.aipia.payment.service;

import com.example.aipia.common.exception.CustomException;
import com.example.aipia.order.model.OrderEntity;
import com.example.aipia.payment.dto.PaymentRegisterRequest;
import com.example.aipia.payment.model.PaymentEntity;
import com.example.aipia.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public void requestPayment(PaymentRegisterRequest request, OrderEntity order) {
        PaymentEntity payment = new PaymentEntity(request, order);
        paymentRepository.save(payment);
    }

    @Transactional
    public void cancelPayment(Long paymentId) {
        PaymentEntity payment = paymentRepository.findById(paymentId).orElseThrow(() -> new CustomException("존재하지 않는 결재번호입니다."));
        payment.cancelPayment();
    }

    @Transactional
    public PaymentEntity getPayment(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(() -> new CustomException("존재하지 않는 결재번호입니다."));
    }
}
