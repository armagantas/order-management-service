package com.armagantas.ordermanagementservice.domain.events;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class OrderCreatedEvent {
    private UUID orderId;
    private Long productId;
    private String doerId;
    private String doer;
    private String receiverId;
    private String receiver;
    private Instant createdAt;
}
