package com.coding.chatbot.infrastructure.client.config;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up Feign client with custom request interceptor.
 */
@Slf4j
@Configuration
public class FeingGroqConfig {

    /**
     * The API key for authentication with the Groq API.
     */
    @Value("${grop.api.key}")
    private String apiKey;

    /**
     * Creates a request interceptor that adds the Authorization header to each request.
     *
     * @return the request interceptor
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        log.info("Setting up request interceptor with adding headers");
        return requestTemplate -> requestTemplate.header("Authorization", String.format("Bearer %s", apiKey));
    }

    /**
     * Creates an error decoder for decoding the error response from the client.
     *
     * @return the error decoder
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new ClientErrorDecoder();
    }
}
