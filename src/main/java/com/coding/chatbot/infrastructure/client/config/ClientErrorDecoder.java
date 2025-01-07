package com.coding.chatbot.infrastructure.client.config;

import com.coding.chatbot.infrastructure.client.entity.ErrorResponseFeingClientInfo;
import com.coding.chatbot.infrastructure.client.exception.BadRequestException;
import com.coding.chatbot.infrastructure.client.exception.ResourceNotFoundException;
import com.coding.chatbot.infrastructure.client.exception.UnauthorizedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClientErrorDecoder class to decode the error response from the client.
 */
@Slf4j
public class ClientErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Decode the error response from the client.
     *
     * @param methodKey the method key
     * @param response the response
     * @return the exception
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        log.error("Error occurred while calling the client: {}", response.reason());
        String errorMessage = getErrorMessage(response);
        return switch (response.status()) {
            case 400 -> new BadRequestException(errorMessage);
            case 404 -> new ResourceNotFoundException(errorMessage);
            case 401 -> new UnauthorizedException(errorMessage);
            default -> new Exception(errorMessage);
        };
    }

    /**
     * Get the error message from the response.
     *
     * @param response the response
     * @return the error message
     */
    private String getErrorMessage(Response response) {
        try (InputStream bodyIs = response.body().asInputStream()) {
            log.error("Error message: {}", bodyIs);
            ErrorResponseFeingClientInfo apiError = objectMapper.readValue(bodyIs, ErrorResponseFeingClientInfo.class);
            return apiError.getError().getMessage();
        } catch (IOException e) {
            log.error("Error occurred while reading the error message", e);
            return "An error occurred, but the error message couldn't be read";
        }
    }

}
