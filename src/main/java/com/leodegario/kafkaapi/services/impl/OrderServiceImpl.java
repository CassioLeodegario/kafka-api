package com.leodegario.kafkaapi.services.impl;

import com.leodegario.kafkaapi.domain.enums.OrderStatus;
import com.leodegario.kafkaapi.domain.models.Order;
import com.leodegario.kafkaapi.events.KafkaClient;
import com.leodegario.kafkaapi.mappers.OrderMapper;
import com.leodegario.kafkaapi.repositories.OrderRepository;
import com.leodegario.kafkaapi.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final KafkaClient kafkaClient;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        order.setIdentifier(UUID.randomUUID().toString());
        order.setOrderDate(LocalDate.now());
        order.setStatus(OrderStatus.PENDINDG);
        order.getItems()
                .forEach(orderItem -> orderItem.setOrder(order));
        orderRepository.save(order);
        kafkaClient.sendMessage(OrderMapper.toDto(order));
        return order;

    }
}
