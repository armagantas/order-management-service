package com.armagantas.ordermanagementservice.application.clients;

import com.armagantas.ordermanagementservice.domain.models.ReceiverInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceClient {
    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ReceiverInfo getReceiverByProductId(Long productId) {
        String url = "http://localhost:8082/products/" + productId + "/owner";

        ResponseEntity<?> response = restTemplate.getForEntity(url, Object.class);
        
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            try {
                @SuppressWarnings("unchecked")
                java.util.Map<String, Object> responseBody = (java.util.Map<String, Object>) response.getBody();
                
                if (responseBody.containsKey("success") && Boolean.TRUE.equals(responseBody.get("success"))) {
                    @SuppressWarnings("unchecked")
                    java.util.Map<String, Object> data = (java.util.Map<String, Object>) responseBody.get("data");
                    
                    if (data != null) {
                        ReceiverInfo receiverInfo = new ReceiverInfo();
                        receiverInfo.setUserId(data.get("userId") != null ? data.get("userId").toString() : null);
                        receiverInfo.setUsername(data.get("username") != null ? data.get("username").toString() : null);
                        return receiverInfo;
                    }
                }
            } catch (Exception e) {
                System.err.println("Ürün sahibi bilgisi işlenirken hata: " + e.getMessage());
            }
        }
        
        // Hata durumunda boş bir nesne döndür
        return new ReceiverInfo();
    }
}
