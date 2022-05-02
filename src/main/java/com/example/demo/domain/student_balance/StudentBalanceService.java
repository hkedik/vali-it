package com.example.demo.domain.student_balance;


import com.example.demo.domain.group_balance.GroupBalance;
import com.example.demo.domain.group_balance.GroupBalanceRepository;
import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.student.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


@Service
public class StudentBalanceService {

    @Resource
    private GroupBalanceService groupBalanceService;

    @Resource
    private StudentBalanceRepository studentBalanceRepository;


    public void addNewStudentBalance(Student student, Integer groupId) {
        StudentBalance studentBalance = new StudentBalance();
        studentBalance.setStudent(student);
        studentBalance.setBalance(BigDecimal.valueOf(0.00));
        GroupBalance groupBalanceByGroupId = groupBalanceService.findGroupBalanceByGroupId(groupId);
        studentBalance.setGroupBalance(groupBalanceByGroupId);
        studentBalanceRepository.save(studentBalance);
    }
}
