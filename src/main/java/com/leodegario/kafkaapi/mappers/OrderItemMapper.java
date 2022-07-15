package com.leodegario.kafkaapi.mappers;

import com.leodegario.kafkaapi.dtos.OrderItemDto;
import com.leodegario.kafkaapi.models.OrderItem;
import org.springframework.beans.BeanUtils;

public class OrderItemMapper {

    public static OrderItem fromDto(OrderItemDto orderItemDto){
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderItemDto, orderItem);
        return orderItem;
    }

    public static OrderItemDto toDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        BeanUtils.copyProperties(orderItem, orderItemDto);
        return orderItemDto;
    }
}
