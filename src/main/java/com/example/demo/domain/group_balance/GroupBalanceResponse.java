package com.example.demo.domain.group_balance;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GroupBalanceResponse implements Serializable {
    private final Integer id;
    private final BigDecimal balance;
    private final Integer groupInfoId;
}
