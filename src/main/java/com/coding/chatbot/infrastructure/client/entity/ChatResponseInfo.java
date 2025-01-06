package com.coding.chatbot.infrastructure.client.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ChatResponseInfo {
    private String id;
    private String object;
    private int created;
    private String model;
    private List<ChoiceInfo> choices;
    private Object usage;
    private String system_fingerprint;
    private Object x_groq;

}
