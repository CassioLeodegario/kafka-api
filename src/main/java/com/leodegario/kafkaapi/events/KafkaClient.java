package com.leodegario.kafkaapi.events;

import com.leodegario.kafkaapi.dtos.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaClient {

    private final KafkaTemplate<String, OrderDto> kafkaTemplate;
    private static final String ORDER_TOPIC_NAME = "ORDER_TOPIC";

    public void sendMessage(OrderDto msg){
        kafkaTemplate.send(ORDER_TOPIC_NAME, msg);
    }


}
