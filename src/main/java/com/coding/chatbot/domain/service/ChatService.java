package com.coding.chatbot.domain.service;

import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import com.coding.chatbot.domain.model.Model;

import java.util.List;

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

    /**
     * Retrieves the available models.
     *
     * @return the available models
     */
    List<Model> getModels();

    /**
     * Retrieves the model information for the given model.
     *
     * @param model the model request domain model
     * @return the model information
     */
    Model getModel(String model);
}
