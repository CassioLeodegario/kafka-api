package com.leodegario.kafkaapi.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String productIdentifier;

    private Integer amount;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

}
