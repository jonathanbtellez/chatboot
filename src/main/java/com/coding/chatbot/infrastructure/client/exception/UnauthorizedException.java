package com.coding.chatbot.infrastructure.client.exception;

/**
 * UnauthorizedException class to handle unauthorized exception
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
