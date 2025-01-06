package com.coding.chatbot.infrastructure.service;

import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import com.coding.chatbot.domain.service.ChatService;
import com.coding.chatbot.infrastructure.client.ChatFeingClient;
import com.coding.chatbot.infrastructure.client.mapper.ChatClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation for handling chat operations.
 */
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatFeingClient chatFeingClient;

    /**
     * Retrieves a chat response based on the given chat request.
     *
     * @param chatRequest the chat request domain model
     * @return the corresponding chat response domain model
     */
    @Override
    public ChatResponse getChatResponse(ChatRequest chatRequest) {
        return ChatClientMapper.fromChatResponseInfo(chatFeingClient.getChatResponse(ChatClientMapper.fromChatRequest(chatRequest)));
    }
}
