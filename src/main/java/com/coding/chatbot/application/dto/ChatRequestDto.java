package com.coding.chatbot.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ChatRequestDto {
    @Value("${grop.api.defaulModel}")
    private String modelName;
    @NotNull(message = "The content must not be null")
    private String content;
}
