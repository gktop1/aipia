package com.example.aipia.payment.controller;

import com.example.aipia.facade.TransactionFacade;
import com.example.aipia.payment.dto.PaymentRegisterRequest;
import com.example.aipia.payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final TransactionFacade transactionFacade;

    @PostMapping("")
    public String requestPayment(@Valid PaymentRegisterRequest request) {
        transactionFacade.requestPayment(request);

        return "SUCCESS";
    }

    @PostMapping("/{paymentId}/cancel")
    public String cancelPayment(@PathVariable Long paymentId) {
        paymentService.cancelPayment(paymentId);

        return "SUCCESS";
    }

    @PostMapping("/{paymentId}/complete")
    public String completePayment(@PathVariable Long paymentId) {
        transactionFacade.completePayment(paymentId);

        return "SUCCESS";
    }


}
