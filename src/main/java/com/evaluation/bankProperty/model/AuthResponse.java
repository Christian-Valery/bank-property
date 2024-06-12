package com.evaluation.bankProperty.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {

    @JsonProperty("Code")
    private String statusCode;

    @JsonProperty("Message")
    private String statusReason;

    @JsonProperty("Token")
    private String token;

    public AuthResponse(String statusCode, String tokenOrStatusCode) {
        this.statusCode = statusCode;
        if(tokenOrStatusCode.startsWith("Login"))
            this.statusReason = tokenOrStatusCode;
        else
            this.token = tokenOrStatusCode;
    }

    public AuthResponse() { }
}
