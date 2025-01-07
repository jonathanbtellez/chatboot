package com.coding.chatbot.application.controller;

import com.coding.chatbot.application.dto.ChatRequestDto;
import com.coding.chatbot.application.dto.SuccessResponseDto;
import com.coding.chatbot.application.mapper.ChatMapper;
import com.coding.chatbot.application.mapper.SuccessResponseMapper;
import com.coding.chatbot.domain.service.ChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for handling chat requests.
 */
@Slf4j
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;


    /**
     * Handles chat requests.
     *
     * @param chatRequestDto the chat request data transfer object
     * @return a ResponseEntity containing the chat response
     */
    @PostMapping
    public ResponseEntity<SuccessResponseDto<?>> chat(
           @Valid @RequestBody ChatRequestDto chatRequestDto) {
        log.info("Chat request received");
        return ResponseEntity.ok()
                .body(
                        SuccessResponseMapper
                                .fromOkResponse(ChatMapper.fromChatResponse(chatService.getChatResponse(ChatMapper.fromChatRequestDto(chatRequestDto))))
                );
    }

    /**
     * Retrieves the available models.
     *
     * @return a ResponseEntity containing the available models
     */
    @GetMapping("/models")
    public ResponseEntity<SuccessResponseDto<?>> getModels() {
        log.info("Request to get models received.");
        return ResponseEntity.ok().body(
                SuccessResponseMapper.fromOkResponse(ChatMapper.fromModelList(chatService.getModels()))
        );
    }
}
