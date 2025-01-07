package com.coding.chatbot.infrastructure.service;

import com.coding.chatbot.domain.model.ChatRequest;
import com.coding.chatbot.domain.model.ChatResponse;
import com.coding.chatbot.domain.model.Model;
import com.coding.chatbot.infrastructure.client.ChatFeingClient;
import com.coding.chatbot.infrastructure.client.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

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

        ChatRequest request = ChatRequest.builder().modelName("llama").content("text").build();
        ModelInfo model = ModelInfo.builder().id("1").owned_by("test").active(true).build();

        // Arrange
        when(chatFeingClient.getModel(any(String.class))).thenReturn(model);
        when(chatFeingClient.getChatResponse(any(ChatRequestInfo.class))).thenReturn(chatResponseInfo);
        // Act
        ChatResponse chatResponseCurrent = chatServiceImpl.getChatResponse(request);

        // Assert
        assertEquals(response.getMessage(), chatResponseCurrent.getMessage());

    }

    @Test
    void testGetModels() {
        // Arrange
        List<Model> models = List.of(
                Model.builder().id("1").owned_by("test").active(true).build(),
                Model.builder().id("2").owned_by("test").active(true).build()
        );

        ModelsInfo modelInfo = ModelsInfo.builder()
                .object("list")
                .data(
                        models.stream().map(model -> ModelInfo.builder()
                                .id(model.getId())
                                .owned_by(model.getOwned_by())
                                .active(model.isActive())
                                .build()).toList()
                )
                .build();

        when(chatFeingClient.getModels()).thenReturn(modelInfo);
        // Act
        List<Model> modelsCurrent = chatServiceImpl.getModels();

        // Assert
        assertEquals(models.size(), modelsCurrent.size());
        verify(chatFeingClient, times(1)).getModels();
    }

}