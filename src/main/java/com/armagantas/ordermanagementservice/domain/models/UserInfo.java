package com.armagantas.ordermanagementservice.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
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
