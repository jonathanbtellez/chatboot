package com.coding.chatbot.infrastructure.client.exception;

/**
 * ResourceNotFoundException class to handle resource not found exception
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
