package com.example.infrastructure.error;

import lombok.Data;

@Data
public class GroupBalanceError {
    private String message;
    private Integer errorCode;
}
