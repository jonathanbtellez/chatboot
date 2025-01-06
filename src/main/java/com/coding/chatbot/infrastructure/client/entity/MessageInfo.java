package com.coding.chatbot.infrastructure.client.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MessageInfo {
    private String role;
    private String content;
}
