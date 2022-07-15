package com.leodegario.kafkaapi.services;

import com.leodegario.kafkaapi.domain.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order createOrder(Order fromDto);
}
