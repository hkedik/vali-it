package com.example.demo.domain.expence;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class ExpenceRequest implements Serializable {
    private final Integer groupBalanceId;
    private final BigDecimal groupBalanceBalance;
    private final String name;
    private final String description;
    private final Integer amount;
    private final Instant dateTime;
}
