package com.example.demo.domain.user_role.student_balance_log;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class StudentBalanceLogResponse {
    private String transferName;
    private String description;
    private BigDecimal amount;
    private String type;
    private Instant dateTime;
}
