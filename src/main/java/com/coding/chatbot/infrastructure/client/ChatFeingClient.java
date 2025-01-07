package com.coding.chatbot.infrastructure.client;

import com.coding.chatbot.infrastructure.client.config.FeingGroqConfig;
import com.coding.chatbot.infrastructure.client.entity.ChatRequestInfo;
import com.coding.chatbot.infrastructure.client.entity.ChatResponseInfo;
import com.coding.chatbot.infrastructure.client.entity.ModelInfo;
import com.coding.chatbot.infrastructure.client.entity.ModelsInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Feign client for the chat API.
 */
@FeignClient(name = "chat", url="${grop.api.url}", configuration = FeingGroqConfig.class)
public interface ChatFeingClient {

    /**
     * Retrieves a chat response based on the given chat request.
     *
     * @param chatRequestInfo the chat request entity
     * @return the corresponding chat response entity
     */
    @PostMapping(value = "/chat/completions", consumes = "application/json")
    ChatResponseInfo getChatResponse(ChatRequestInfo chatRequestInfo);

    /**
     * Retrieves the available models.
     *
     * @return the available models
     */
    @GetMapping(value = "/models", consumes = "application/json")
    ModelsInfo getModels();

    /**
     * Retrieves the model information for the given model.
     *
     * @param model the model
     * @return the model information
     */
    @GetMapping(value = "/models/{model}", consumes = "application/json")
    ModelInfo getModel(
           @PathVariable String model);
}
