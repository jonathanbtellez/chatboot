package com.coding.chatbot.infrastructure.client;

import com.coding.chatbot.infrastructure.client.config.FeingGroqConfig;
import com.coding.chatbot.infrastructure.client.entity.ChatRequestInfo;
import com.coding.chatbot.infrastructure.client.entity.ChatResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
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
    @PostMapping(value = "", consumes = "application/json")
    ChatResponseInfo getChatResponse(ChatRequestInfo chatRequestInfo);
}
