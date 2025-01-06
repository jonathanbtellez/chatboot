package com.coding.chatbot.infrastructure.service;

import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import com.coding.chatbot.infrastructure.client.ChatFeingClient;
import com.coding.chatbot.infrastructure.client.entity.ChatRequestInfo;
import com.coding.chatbot.infrastructure.client.entity.ChatResponseInfo;
import com.coding.chatbot.infrastructure.client.entity.ChoiceInfo;
import com.coding.chatbot.infrastructure.client.entity.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ChatServiceImplTest {
    @Mock
    private ChatFeingClient chatFeingClient;

    @InjectMocks
    private ChatServiceImpl chatServiceImpl;

    @Test
    void testGetChatResponse() {
        ChatResponse response = ChatResponse.builder().message("I am a test question").build();
        ChatResponseInfo chatResponseInfo = ChatResponseInfo.builder()
                .choices(Collections.singletonList(ChoiceInfo.builder()
                        .message(MessageInfo.builder()
                                .content(response.getMessage())
                                .build())
                        .build()))
                .build();

        ChatRequest request = ChatRequest.builder().content("text").build();
        // Arrange
        when(chatFeingClient.getChatResponse(any(ChatRequestInfo.class))).thenReturn(chatResponseInfo);
        // Act
        ChatResponse chatResponseCurrent = chatServiceImpl.getChatResponse(request);

        // Assert
        assertEquals(response.getMessage(), chatResponseCurrent.getMessage());

    }

}