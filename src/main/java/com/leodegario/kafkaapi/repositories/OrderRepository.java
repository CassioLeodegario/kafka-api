package com.leodegario.kafkaapi.repositories;

import com.leodegario.kafkaapi.domain.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
