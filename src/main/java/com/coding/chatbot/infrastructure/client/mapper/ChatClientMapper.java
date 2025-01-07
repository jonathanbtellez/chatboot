package com.coding.chatbot.infrastructure.client.mapper;

import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import com.coding.chatbot.domain.model.Model;
import com.coding.chatbot.infrastructure.client.entity.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * Mapper for converting between ChatRequest and ChatResponse domain models and their corresponding client entities.
 */
@Slf4j
public class ChatClientMapper {

    /**
     * Converts a ChatRequest to a ChatRequestInfo.
     *
     * @param chatRequest the chat request domain model
     * @return the corresponding ChatRequestInfo
     */
    public static ChatRequestInfo fromChatRequest(final ChatRequest chatRequest) {
       log.info("Mapping ChatRequest to ChatRequestInfo.");
        return ChatRequestInfo.builder()
                .model(chatRequest.getModelName())
                .messages(Collections.singletonList(MessageInfo.builder()
                        .role("user")
                        .content(chatRequest.getContent())
                        .build()))
                .build();
    }

    /**
     * Converts a ChatResponseInfo to a ChatResponse.
     *
     * @param chatResponseInfo the chat response entity
     * @return the corresponding ChatResponse
     */
    public static ChatResponse fromChatResponseInfo(final ChatResponseInfo chatResponseInfo) {
        log.info("Mapping ChatResponseInfo to ChatResponse.");
        return ChatResponse.builder()
                .message(chatResponseInfo.getChoices().get(0).getMessage().getContent())
                .build();
    }

    /**
     * Converts a ModelsInfo to a list of Model domain models.
     *
     * @param modelsInfo the models entity
     * @return the corresponding list of Model domain models
     */
    public static List<Model> fromModelsInfo(final ModelsInfo modelsInfo) {
        log.info("Mapping ModelsInfo to Model.");
        return modelsInfo.getData().stream()
                .map(modelInfo -> Model.builder()
                        .id(modelInfo.getId())
                        .owned_by(modelInfo.getOwned_by())
                        .active(modelInfo.isActive())
                        .build())
                .toList();
    }

    /**
     * Converts a ModelInfo to a Model domain model.
     *
     * @param modelInfo the model entity
     * @return the corresponding Model domain model
     */
    public static Model fromModelInfo(final ModelInfo modelInfo) {
        log.info("Mapping ModelInfo to Model.");
        return Model.builder()
                .id(modelInfo.getId())
                .owned_by(modelInfo.getOwned_by())
                .active(modelInfo.isActive())
                .build();
    }

}
