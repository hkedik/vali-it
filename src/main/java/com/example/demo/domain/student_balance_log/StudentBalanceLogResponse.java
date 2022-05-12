package com.example.demo.domain.student_balance_log;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentBalanceLogResponse {
    private String transferName;
    private String description;
    private BigDecimal amount;
    private String type;
    private String dateTime;
}
