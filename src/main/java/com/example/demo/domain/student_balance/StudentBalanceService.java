package com.example.demo.domain.student_balance;


import com.example.demo.domain.group_balance.GroupBalance;
import com.example.demo.domain.group_balance.GroupBalanceRepository;
import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentInfoResponse;
import com.example.demo.domain.student_balance_log.StudentBalanceLogService;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;


@Service
public class StudentBalanceService {

    @Resource
    private GroupBalanceService groupBalanceService;

    @Resource
    private StudentBalanceRepository studentBalanceRepository;

    @Resource
    private ValidationService validationService;

    @Resource
    private StudentBalanceLogService studentBalanceLogService;

    @Resource
    private StudentBalanceMapper studentBalanceMapper;


    public void addNewStudentBalance(Student student, Integer groupId) {
        StudentBalance studentBalance = new StudentBalance();
        studentBalance.setStudent(student);
        studentBalance.setBalance(BigDecimal.valueOf(0.00));
        GroupBalance groupBalanceByGroupId = groupBalanceService.findGroupBalanceByGroupId(groupId);
        studentBalance.setGroupBalance(groupBalanceByGroupId);
        studentBalanceRepository.save(studentBalance);
    }

    public void addMoneyToStudentAccount(Integer studentId, BigDecimal amount) {
        Optional<StudentBalance> byStudent_id = studentBalanceRepository.findByStudent_Id(studentId);
        validationService.isValidStudentBalance(byStudent_id);
        StudentBalance studentBalance = byStudent_id.get();
        BigDecimal balance = studentBalance.getBalance();
        studentBalance.setBalance(balance.add(amount));
        studentBalanceRepository.save(studentBalance);
        GroupBalance groupBalance = studentBalance.getGroupBalance();
        groupBalanceService.addMoneyToGroupBalance(groupBalance.getId(), amount);
        studentBalanceLogService.addMoneyBalanceLog(amount, studentBalance);


    }

    public StudentBalanceResponse findStudentBalanceById(Integer id) {
        Optional<StudentBalance> byStudentId = studentBalanceRepository.findByStudent_Id(id);
        validationService.isValidStudentBalance(byStudentId);
        StudentBalance studentBalance = byStudentId.get();
        StudentBalanceResponse studentBalanceResponse = studentBalanceMapper.studentBalanceToStudentBalanceResponse(studentBalance);
        return studentBalanceResponse;

    }


    public StudentBalance creditStudentBalance(StudentInfoResponse selectedStudent, BigDecimal amount) {
        Optional<StudentBalance> byStudent_id = studentBalanceRepository.findByStudent_Id(selectedStudent.getStudentId());
        validationService.isValidStudentBalance(byStudent_id);
        StudentBalance studentBalance = byStudent_id.get();
        BigDecimal balance = studentBalance.getBalance();
        studentBalance.setBalance(balance.subtract(amount));
        studentBalanceRepository.save(studentBalance);
        return studentBalance;

    }

    public StudentBalance findStudentBalanceByStudentId(Integer id) {
        Optional<StudentBalance> balance = studentBalanceRepository.findByStudent_Id(id);
        validationService.isValidStudentBalance(balance);
        return balance.get();
    }
}
