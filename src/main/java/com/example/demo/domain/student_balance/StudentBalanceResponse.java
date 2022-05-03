package com.example.demo.domain.student_balance;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class StudentBalanceResponse implements Serializable {
    private final Integer id;
    private final Integer groupBalanceId;
    private final BigDecimal groupBalanceBalance;
    private final Integer studentId;
    private final BigDecimal balance;
}
