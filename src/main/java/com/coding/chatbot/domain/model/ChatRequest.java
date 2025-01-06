package com.coding.chatbot.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class ChatRequest {
    private String content;
}
