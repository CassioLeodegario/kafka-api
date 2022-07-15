package com.leodegario.kafkaapi;

import com.leodegario.kafkaapi.dtos.OrderDto;
import com.leodegario.kafkaapi.mappers.OrderMapper;
import com.leodegario.kafkaapi.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getOrder(){
        return ResponseEntity.ok(OrderMapper.toDtoList(orderService.findAll()));
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(OrderMapper.toDto(orderService.createOrder(OrderMapper.fromDto(orderDto))));
    }

}
