package com.serasa.testetecnico.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiError {
    private final String message;
    private final int statusCode;
    private final LocalDateTime dateTime;

    public ApiError(final String message, final int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.dateTime = LocalDateTime.now();
    }
}
