package com.example.demo.domain.student_balance_log;

import com.example.demo.domain.expence.Expence;
import com.example.demo.domain.student_balance.StudentBalance;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class StudentBalanceLogResponse {
    private String transferName;
    private String description;
    private BigDecimal amount;
    private String type;
    private String dateTime;
}
