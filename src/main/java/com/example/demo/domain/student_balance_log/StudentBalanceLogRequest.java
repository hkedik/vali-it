package com.example.demo.domain.student_balance_log;

import com.example.demo.domain.expence.Expence;
import com.example.demo.domain.student_balance.StudentBalance;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentBalanceLogRequest {


    private Expence expense;
    private StudentBalance studentBalance;
    private BigDecimal amount;
}
