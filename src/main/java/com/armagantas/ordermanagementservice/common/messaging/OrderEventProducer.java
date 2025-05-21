package com.armagantas.ordermanagementservice.common.messaging;

import com.armagantas.ordermanagementservice.domain.events.OrderCreatedEvent;
import com.armagantas.ordermanagementservice.domain.models.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrderCreatedEvent(Order order) {
        OrderCreatedEvent event = new OrderCreatedEvent(
                order.getId(),
                order.getProductId(),
                order.getDoerId(),
                order.getDoer(),
                order.getReceiverId(),
                order.getReceiver(),
                order.getCreatedAt()
        );

        kafkaTemplate.send("order-created-events.0", event);
    }
}
