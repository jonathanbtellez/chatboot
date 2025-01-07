package com.coding.chatbot.infrastructure.client.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ModelsInfo {
    private String object;
    private List<ModelInfo> data;
}
