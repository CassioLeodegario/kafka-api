package com.leodegario.kafkaapi.repositories;

import com.leodegario.kafkaapi.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
