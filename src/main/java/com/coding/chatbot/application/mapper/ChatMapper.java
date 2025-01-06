package com.coding.chatbot.application.mapper;

import com.coding.chatbot.application.dto.ChatRequestDto;
import com.coding.chatbot.application.dto.ChatResponseDto;
import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * Mapper for converting between ChatRequestDto and domain models.
 */
@Slf4j
public class ChatMapper {

    /**
     * Converts a ChatResponse to a ChatResponseDto.
     *
     * @param chatResponse the chat response domain model
     * @return the corresponding ChatResponseDto
     */
    public static ChatResponseDto fromChatResponse(final ChatResponse chatResponse) {
        log.info("Mapping ChatResponse to ChatResponseDto.");
        return ChatResponseDto.builder()
                .message(chatResponse.getMessage())
                .build();
    }

    /**
     * Converts a ChatRequestDto to a ChatRequest.
     *
     * @param chatRequestDto the chat request data transfer object
     * @return the corresponding ChatRequest domain model
     */
    public static ChatRequest fromChatRequestDto(final ChatRequestDto chatRequestDto) {
        log.info("Mapping ChatRequestDto to ChatRequest.");
        return ChatRequest.builder()
                .modelName(chatRequestDto.getModelName())
                .content(chatRequestDto.getContent())
                .build();
    }
}
