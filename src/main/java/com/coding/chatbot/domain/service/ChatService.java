package com.coding.chatbot.domain.service;

import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;

/**
 * Service interface for handling chat operations.
 */
public interface ChatService {

    /**
     * Retrieves a chat response based on the given chat request.
     *
     * @param chatRequest the chat request domain model
     * @return the corresponding chat response domain model
     */
    ChatResponse getChatResponse(ChatRequest chatRequest);
}
