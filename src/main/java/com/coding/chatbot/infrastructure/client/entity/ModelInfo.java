package com.coding.chatbot.infrastructure.client.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ModelInfo {
    public String id;
    public String object;
    public int created;
    public String owned_by;
    public boolean active;
    public int context_window;
    public Object public_apps;
}
