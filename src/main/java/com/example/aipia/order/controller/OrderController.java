package com.example.aipia.order.controller;

import com.example.aipia.facade.TransactionFacade;
import com.example.aipia.order.dto.OrderRegisterRequest;
import com.example.aipia.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;
    private final TransactionFacade transactionFacade;

    @PostMapping("")
    public String requestOrder(@Valid OrderRegisterRequest request) {
        transactionFacade.requestOrder(request);

        return "SUCCESS";
    }

    @PatchMapping("/{orderId}/cancel")
    public String cancelOrder(@PathVariable Long orderId) {

        orderService.cancelOrder(orderId);

        return "SUCCESS";
    }

}
