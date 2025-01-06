package com.coding.chatbot.infrastructure.client.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ChoiceInfo {
    private int index;
    private MessageInfo message;
    private Object logprobs;
    private String finish_reason;
}
