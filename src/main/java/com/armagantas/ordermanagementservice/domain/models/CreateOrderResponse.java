package com.armagantas.ordermanagementservice.domain.models;

import java.time.Instant;
import java.util.UUID;

public class CreateOrderResponse {
    private UUID id;
    private OrderStatus orderStatus;
    private Instant createdAt;
    
    // Manuel getter metotları
    public UUID getId() {
        return id;
    }
    
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    
    public Instant getCreatedAt() {
        return createdAt;
    }
    
    // Manuel setter metotları
    public void setId(UUID id) {
        this.id = id;
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    
    // Constructorlar
    public CreateOrderResponse() {
    }
    
    public CreateOrderResponse(UUID id, OrderStatus orderStatus, Instant createdAt) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }
}
