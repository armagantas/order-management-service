package com.armagantas.ordermanagementservice.controller;

import com.armagantas.ordermanagementservice.domain.models.CreateOrderRequest;
import com.armagantas.ordermanagementservice.domain.models.CreateOrderResponse;
import com.armagantas.ordermanagementservice.domain.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create/{productId}")
    public ResponseEntity<CreateOrderResponse> createOrder(
            @RequestBody CreateOrderRequest createOrderRequest,
            @PathVariable Long productId,
            @RequestHeader("Authorization") String token) {
        
        createOrderRequest.setProductId(productId);
        
        return orderService.createOrder(createOrderRequest, token);
    }
}
