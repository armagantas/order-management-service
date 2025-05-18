package com.armagantas.ordermanagementservice.application.clients;

import com.armagantas.ordermanagementservice.domain.models.ReceiverInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceClient {
    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ReceiverInfo getReceiverByProductId(String productId) {
        String url = "http://product-service/api/products/" + productId;

        return restTemplate.getForObject(url, ReceiverInfo.class);
    }
}
