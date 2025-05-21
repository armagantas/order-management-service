package com.armagantas.ordermanagementservice.domain.services;

import com.armagantas.ordermanagementservice.application.clients.CustomerServiceClient;
import com.armagantas.ordermanagementservice.application.clients.ProductServiceClient;
import com.armagantas.ordermanagementservice.application.repository.OrderRepository;
import com.armagantas.ordermanagementservice.common.messaging.OrderEventProducer;
import com.armagantas.ordermanagementservice.domain.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerServiceClient customerServiceClient;
    private final ProductServiceClient productServiceClient;
    private final OrderEventProducer orderEventProducer;

    public OrderService(OrderRepository orderRepository,
                        CustomerServiceClient customerServiceClient,
                        ProductServiceClient productServiceClient,
                        OrderEventProducer orderEventProducer) {
        this.orderRepository = orderRepository;
        this.customerServiceClient = customerServiceClient;
        this.productServiceClient = productServiceClient;
        this.orderEventProducer = orderEventProducer;
    }

    public ResponseEntity<CreateOrderResponse> createOrder(CreateOrderRequest request, String token) {
        UserInfo userInfo = customerServiceClient.getUserInfo(token);
        if (userInfo == null) {
            return ResponseEntity.status(401).body(null);
        }

        ReceiverInfo product = productServiceClient.getReceiverByProductId(request.getProductId());

        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setOrderPrice(request.getOrderPrice());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setProductId(request.getProductId());
        order.setDoer(userInfo.getUsername());
        order.setDoerId(userInfo.getUserId());
        order.setReceiver(product.getUsername());
        order.setReceiverId(product.getUserId());
        order.setCreatedAt(Instant.now());
        order.setUpdatedAt(Instant.now());

        Order saved = orderRepository.save(order);

        orderEventProducer.publishOrderCreatedEvent(saved);

        CreateOrderResponse response = new CreateOrderResponse(
                saved.getId(),
                saved.getOrderStatus(),
                saved.getCreatedAt()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
}
