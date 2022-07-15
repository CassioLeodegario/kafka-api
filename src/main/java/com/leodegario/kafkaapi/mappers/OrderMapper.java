package com.leodegario.kafkaapi.mappers;

import com.leodegario.kafkaapi.dtos.OrderDto;
import com.leodegario.kafkaapi.domain.models.Order;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static Order fromDto(OrderDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        order.setItems(orderDto.getItems().stream()
                .map(OrderItemMapper::fromDto)
                .collect(Collectors.toList()));
        return order;
    }

    public static OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        orderDto.setItems(order.getItems().stream()
                .map(OrderItemMapper::toDto)
                .collect(Collectors.toList()));
        return orderDto;
    }

    public static List<OrderDto> toDtoList(List<Order> orders){
        return orders.stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }
}
