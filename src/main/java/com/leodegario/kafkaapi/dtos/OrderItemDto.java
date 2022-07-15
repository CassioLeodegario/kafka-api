package com.leodegario.kafkaapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemDto {
    private String productIdentifier;
    private Integer amount;
    private BigDecimal price;
}
