package com.coding.chatbot.infrastructure.service;

import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import com.coding.chatbot.domain.model.Model;
import com.coding.chatbot.domain.service.ChatService;
import com.coding.chatbot.infrastructure.client.ChatFeingClient;
import com.coding.chatbot.infrastructure.client.mapper.ChatClientMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for handling chat operations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    @Value("${grop.api.defaulModel}")
    private String defaultModel;
    private final ChatFeingClient chatFeingClient;

    /**
     * Retrieves a chat response based on the given chat request.
     *
     * @param chatRequest the chat request domain model
     * @return the corresponding chat response domain model
     */
    @Override
    public ChatResponse getChatResponse(ChatRequest chatRequest) {
        log.info("Getting chat response");
        if(chatRequest.getModelName() == null) {
            log.info("Model name is null, setting default model");
            chatRequest.setModelName(defaultModel);
        }

        getModel(chatRequest.getModelName());
        log.info("Getting chat response from client");
        return ChatClientMapper.fromChatResponseInfo(
                chatFeingClient.getChatResponse(ChatClientMapper.fromChatRequest(chatRequest))
        );
    }

    /**
     * Retrieves the available models.
     *
     * @return the available models
     */
    @Override
    public List<Model> getModels() {
        log.info("Getting models");
        return ChatClientMapper.fromModelsInfo(chatFeingClient.getModels());
    }

    /**
     * Retrieves the model information for the given model.
     *
     * @param model the model request domain model
     * @return the model information
     */
    public Model getModel(String model) {
        log.info("Getting model");
        return ChatClientMapper.fromModelInfo(chatFeingClient.getModel(model));
    }
}
