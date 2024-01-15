package com.taidt9.OrderService.service;

import com.taidt9.OrderService.entity.Order;
import com.taidt9.OrderService.enumeration.OrderStatus;
import com.taidt9.OrderService.model.OrderDTO;
import com.taidt9.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    @Override
    public long addOrder(OrderDTO orderDTO) {
        log.info("Order requested: {}", orderDTO);
        Order order = Order.builder()
                .productId(orderDTO.getProductId())
                .quantity(orderDTO.getQuantity())
                .orderDate(Instant.now())
                .orderStatus(OrderStatus.CREATED)
                .amount(orderDTO.getAmount())
                .build();
        order = orderRepository.save(order);
        log.info("Saved successfully with Order: {}", order);
        return  order.getOrderId();
    }
}
