package com.example.demo.domain.expence;


import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.student.StudentService;
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

        Expence expence = expenceMapper.expenceRequestToExpence(request);
        expence.setDateTime(Instant.now());
        expenceRepository.save(expence);
        groupBalanceService.changeGroupBalance(request);
        studentService.changeStudentBalance(request);


    }
}
