package com.coding.chatbot.application.exception;

import com.coding.chatbot.application.dto.ErrorResponseDto;
import com.coding.chatbot.infrastructure.client.exception.BadRequestException;
import com.coding.chatbot.infrastructure.client.exception.ResourceNotFoundException;
import com.coding.chatbot.infrastructure.client.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler class to handle exceptions
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle ResourceNotFoundException
     * @param ex ResourceNotFoundException
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFound(ResourceNotFoundException ex) {
        log.error("Resource not found: {}", ex.getMessage());
        return createErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    /**
     * Handle BadRequestException
     * @param ex BadRequestException
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> BadRequest(BadRequestException ex) {
        log.info("Bad request: {}", ex.getMessage());
        return createErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     * Handle UnauthorizedException
     * @param ex UnauthorizedException
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponseDto> Unauthorized(UnauthorizedException ex) {
        log.info("Unauthorized: {}", ex.getMessage());
        return createErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    /**
     * Handle MethodArgumentNotValidException
     * @param ex MethodArgumentNotValidException
     * @return ResponseEntity<Map<String, String>>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("Validation error: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("status", "error");
        for(FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle Exception
     * @param ex Exception
     * @return ResponseEntity<ErrorResponseDto>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception ex) {
        log.error("Internal server error: {}", ex.getMessage());
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    /**
     * Create error response
     * @param statusCode HttpStatus
     * @param message String
     * @return ResponseEntity<ErrorResponseDto>
     */
    private ResponseEntity<ErrorResponseDto> createErrorResponse(HttpStatus statusCode, String message) {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder().status("error").message(message).build();
        return new ResponseEntity<>(errorResponse, statusCode);
    }
}
