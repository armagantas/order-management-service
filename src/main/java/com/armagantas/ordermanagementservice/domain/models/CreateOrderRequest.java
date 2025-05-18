package com.armagantas.ordermanagementservice.domain.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

public class CreateOrderRequest {
    @NotNull(message = "Product ID boş olamaz")
    private Long productId;

    @Positive(message = "Fiyat pozitif olmalı")
    private float orderPrice;
    
    // Getter metotları
    public Long getProductId() {
        return productId;
    }
    
    public float getOrderPrice() {
        return orderPrice;
    }
    
    // Setter metotları
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }
    
    // Boş constructor
    public CreateOrderRequest() {
    }
    
    // Parametreli constructor
    public CreateOrderRequest(Long productId, float orderPrice) {
        this.productId = productId;
        this.orderPrice = orderPrice;
    }
}
