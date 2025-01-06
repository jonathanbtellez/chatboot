package com.coding.chatbot.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChatRequestDto {
    private String content;
}
