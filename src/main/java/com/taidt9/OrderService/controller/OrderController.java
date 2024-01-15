package com.taidt9.OrderService.controller;

import com.taidt9.OrderService.model.OrderDTO;
import com.taidt9.OrderService.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    private ResponseEntity<Long> ordering(@RequestBody OrderDTO orderDTO) {
        long orderId = orderService.addOrder(orderDTO);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }
}
