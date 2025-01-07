package com.coding.chatbot.infrastructure.client.exception;

/**
 * BadRequestException class to handle bad request exception
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
