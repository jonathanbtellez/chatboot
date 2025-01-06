package com.coding.chatbot.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ChatResponse {
    private String id;
    private String message;
}
