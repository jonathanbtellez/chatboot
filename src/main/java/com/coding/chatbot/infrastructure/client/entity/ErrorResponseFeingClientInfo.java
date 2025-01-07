package com.coding.chatbot.infrastructure.client.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponseFeingClientInfo {
    @JsonProperty("error")
    private ErrorDetails error;

    @Setter
    @Getter
    public static class ErrorDetails {
        private String message;
        private String type;
        private String code;
    }
}
