package com.coding.chatbot.application.mapper;

import com.coding.chatbot.application.dto.SuccessResponseDto;
import lombok.extern.slf4j.Slf4j;

/**
 * Mapper class to map the success response.
 */
@Slf4j
public class SuccessResponseMapper {
    /**
     * Method to map the success response.
     *
     * @param data the data to be mapped.
     * @param <T> the type of the data.
     * @return the mapped success response.
     */
    public static <T> SuccessResponseDto<T> fromOkResponse(T data) {
        log.info("Mapping success response");
        return SuccessResponseDto.<T>builder()
                .status("success")
                .data(data)
                .build();
    }
}
