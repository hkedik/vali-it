package com.example.demo.domain.expence;


import com.example.demo.domain.group_balance.GroupBalanceRepository;
import com.example.demo.domain.group_balance.GroupBalanceResponse;
import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.student.StudentService;
import com.example.demo.domain.student_balance_log.StudentBalanceLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class ExpenceService {

    @Resource
    private ExpenceRepository expenceRepository;

    @Resource
    private ExpenceMapper expenceMapper;

    @Resource
    private GroupBalanceService groupBalanceService;

    @Resource
    private StudentService studentService;

    public void addNewExpense(ExpenseRequest request) {

        Expence expence = new Expence();
        expence.setGroupBalance(groupBalanceService.findGroupBalanceByGroupId(request.getGroupId()));
        expence.setName(request.getName());
        expence.setDescription(request.getDescription());
        expence.setAmount(request.getAmount());
        expence.setDateTime(Instant.now());
        expenceRepository.save(expence);
        groupBalanceService.changeGroupBalance(request);
        studentService.changeStudentBalance(request ,expence);


    }
}
