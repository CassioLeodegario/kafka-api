package com.leodegario.kafkaapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private long id;
    private String identifier;
    private String status;
    private LocalDate orderDate;
    private List<OrderItemDto> items;

}
