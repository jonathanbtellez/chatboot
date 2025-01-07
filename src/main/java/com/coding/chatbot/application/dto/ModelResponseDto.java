package com.coding.chatbot.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ModelResponseDto {
    public String id;
    public String owned_by;
    public boolean active;
}
