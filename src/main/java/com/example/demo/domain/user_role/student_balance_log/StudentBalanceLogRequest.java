package com.example.demo.domain.user_role.student_balance_log;

import com.example.demo.domain.expense.Expense;
import com.example.demo.domain.student_balance.StudentBalance;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentBalanceLogRequest {

    private Expense expense;
    private StudentBalance studentBalance;
    private BigDecimal amount;
}
