package com.coding.chatbot.application.mapper;

import com.coding.chatbot.application.dto.ChatRequestDto;
import com.coding.chatbot.application.dto.ChatResponseDto;
import com.coding.chatbot.application.dto.ModelResponseDto;
import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import com.coding.chatbot.domain.model.Model;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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

    /**
     * Converts a ModelList to a list of ModelResponseDto.
     *
     * @param modelList the model list
     * @return the corresponding list of ModelResponseDto
     */
    public  static List<ModelResponseDto> fromModelList(List<Model> modelList) {
        log.info("Mapping ModelList to ModelResponseDto.");
        return modelList.stream().map(model -> ModelResponseDto.builder()
                .id(model.getId())
                .owned_by(model.getOwned_by())
                .active(model.isActive())
                .build()).toList();
    }
}
