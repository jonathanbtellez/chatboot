package com.coding.chatbot.application.controller;

import com.coding.chatbot.application.dto.ChatRequestDto;
import com.coding.chatbot.application.mapper.ChatMapper;
import com.coding.chatbot.domain.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity<?> chat(@RequestBody ChatRequestDto chatRequestDto) {
        log.info("Chat request received: {}", chatRequestDto);
        return ResponseEntity.ok().body(ChatMapper.fromChatResponse(chatService.getChatResponse(ChatMapper.fromChatRequestDto(chatRequestDto))));
    }
}
