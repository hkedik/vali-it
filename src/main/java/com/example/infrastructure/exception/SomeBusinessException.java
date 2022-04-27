package com.example.infrastructure.exception;

import lombok.Data;

@Data
public class SomeBusinessException extends RuntimeException {
    private String message;
    private Integer errorCode;

    public SomeBusinessException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
