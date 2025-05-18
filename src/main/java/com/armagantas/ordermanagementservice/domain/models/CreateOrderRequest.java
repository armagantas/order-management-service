package com.armagantas.ordermanagementservice.domain.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequest {
    @NotBlank(message = "Product ID boş olamaz")
    private String productId;

    @Positive(message = "Fiyat pozitif olmalı")
    private float orderPrice;
}
