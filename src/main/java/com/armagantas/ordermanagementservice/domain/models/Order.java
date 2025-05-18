package com.armagantas.ordermanagementservice.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private UUID id;

    private float orderPrice;

    private String orderStatus;

    private String productId;

    private String doer;

    private String doerId;

    private String receiver;

    private String receiverId;

    private Instant createdAt;

    private Instant updatedAt;
}
