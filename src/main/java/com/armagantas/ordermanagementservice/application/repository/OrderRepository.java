package com.armagantas.ordermanagementservice.application.repository;

import com.armagantas.ordermanagementservice.domain.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findByProductId(String productId);
}
