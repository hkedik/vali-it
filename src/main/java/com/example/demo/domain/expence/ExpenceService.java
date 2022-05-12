package com.example.demo.domain.expence;


import com.example.demo.domain.expense_picture.ExpensePictureService;
import com.example.demo.domain.group_balance.GroupBalanceRepository;
import com.example.demo.domain.group_balance.GroupBalanceResponse;
import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.student.StudentService;
import com.example.demo.domain.student_balance_log.StudentBalanceLogService;
import com.example.demo.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenceService {

    @Resource
    private ExpenceRepository expenceRepository;

    @Resource
    private GroupBalanceService groupBalanceService;

    @Resource
    private StudentService studentService;

    @Resource
    private ExpensePictureService expensePictureService;

    public void addNewExpense(ExpenseRequest request) {
        Expence expence = new Expence();
        expence.setGroupBalance(groupBalanceService.findGroupBalanceByGroupId(request.getGroupId()));
        expence.setName(request.getName());
        expence.setDescription(request.getDescription());
        expence.setAmount(request.getAmount());
        expence.setDateTime(Instant.now());
        expenceRepository.save(expence);
        expensePictureService.saveReceiptPicture(request, expence);
        groupBalanceService.changeGroupBalance(request);
        studentService.changeStudentBalance(request, expence);
    }

    public List<ExpenseResponse> getExpenseLog(Integer groupId) {
        List<Expence> expenses = expenceRepository.findByGroupId(groupId);
        List<ExpenseResponse> response = new ArrayList<>();
        for (Expence expence : expenses) {
            ExpenseResponse responseExpense = new ExpenseResponse();
            responseExpense.setExpenseId(expence.getId());
            responseExpense.setName(expence.getName());
            responseExpense.setDescription(expence.getDescription());
            responseExpense.setAmount(expence.getAmount());
            responseExpense.setDateAndTime(DateUtil.getFormattedDate(expence.getDateTime()));
            response.add(responseExpense);
        }
        return response;
    }

    public Expence getExpenceById(Integer expenseId) {
        return expenceRepository.getById(expenseId);
    }

    public Expence findByExpenseName(String expenseName) {
        return expenceRepository.findByName(expenseName);
    }
}
