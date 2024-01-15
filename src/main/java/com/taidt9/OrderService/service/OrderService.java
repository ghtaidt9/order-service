package com.taidt9.OrderService.service;

import com.taidt9.OrderService.model.OrderDTO;

public interface OrderService {
    long addOrder(OrderDTO orderDTO);
}
