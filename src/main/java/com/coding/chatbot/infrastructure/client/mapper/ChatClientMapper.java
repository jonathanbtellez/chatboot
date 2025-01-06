package com.coding.chatbot.infrastructure.client.mapper;

import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import com.coding.chatbot.infrastructure.client.entity.ChatRequestInfo;
import com.coding.chatbot.infrastructure.client.entity.ChatResponseInfo;
import com.coding.chatbot.infrastructure.client.entity.MessageInfo;

import java.util.Collections;

/**
 * Mapper for converting between ChatRequest and ChatResponse domain models and their corresponding client entities.
 */
public class ChatClientMapper {

    /**
     * Converts a ChatRequest to a ChatRequestInfo.
     *
     * @param chatRequest the chat request domain model
     * @return the corresponding ChatRequestInfo
     */
    public static ChatRequestInfo fromChatRequest(final ChatRequest chatRequest) {
        return ChatRequestInfo.builder()
                .model("gemma2-9b-it")
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
        return ChatResponse.builder()
                .id(chatResponseInfo.getId())
                .message(chatResponseInfo.getChoices().get(0).getMessage().getContent())
                .build();
    }
}
