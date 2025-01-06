package com.coding.chatbot.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ChatResponseDto {
    private String id;
    private String message;
}
