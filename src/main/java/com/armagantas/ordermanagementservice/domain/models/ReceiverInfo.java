package com.armagantas.ordermanagementservice.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiverInfo {
    @JsonProperty("id")
    private String userId;

    private String username;
    
    // Manuel getter metotları
    public String getUserId() {
        return userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    // Manuel setter metotları
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
}
