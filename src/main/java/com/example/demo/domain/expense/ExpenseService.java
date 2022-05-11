package com.example.demo.domain.expense;


import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.student.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Resource
    private ExpenseRepository expenseRepository;

    @Resource
    private GroupBalanceService groupBalanceService;

    @Resource
    private StudentService studentService;

    public void addNewExpense(ExpenseRequest request) {
        Expense expense = new Expense();
        expense.setGroupBalance(groupBalanceService.findGroupBalanceByGroupId(request.getGroupId()));
        expense.setName(request.getName());
        expense.setDescription(request.getDescription());
        expense.setAmount(request.getAmount());
        expense.setDateTime(Instant.now());
        expenseRepository.save(expense);
        groupBalanceService.changeGroupBalance(request);
        studentService.changeStudentBalance(request ,expense);


    }

    public List<ExpenseResponse> getExpenseLog(Integer groupId) {
        List<Expense> expenses = expenseRepository.findByGroupId(groupId);
        List<ExpenseResponse> response = new ArrayList<>();
        for (Expense expense : expenses) {
            ExpenseResponse responseExpense = new ExpenseResponse();
            responseExpense.setGroupId(expense.getId());
            responseExpense.setName(expense.getName());
            responseExpense.setDescription(expense.getDescription());
            responseExpense.setAmount(expense.getAmount());
            responseExpense.setDateAndTime(expense.getDateTime());
            response.add(responseExpense);
        }
        return response;
    }
}
