package com.example.demo.domain.expence;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class ExpenseResponse implements Serializable {
    private Integer expenseId;
    private String name;
    private String description;
    private BigDecimal amount;
    private String dateAndTime;

}
