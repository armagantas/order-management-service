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

}
