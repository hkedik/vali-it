package com.example.infrastructure.exception;

import lombok.Data;

@Data
public class DataNotFoundException extends RuntimeException {
    private String message;
    private Integer errorCode;

    public DataNotFoundException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
