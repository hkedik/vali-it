package com.example.demo.service.moderator;

import com.example.demo.domain.contact.ContactResponse;
import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.expence.ExpenseRequest;
import com.example.demo.domain.expence.ExpenceService;
import com.example.demo.domain.student.StudentInfoResponse;
import com.example.demo.domain.student.StudentService;
import com.example.demo.domain.student_balance.StudentBalanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ModeratorService {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentBalanceService studentBalanceService;

    @Resource
    private ExpenceService expenceService;

    @Resource
    ContactService contactService;


    public List<StudentInfoResponse> allStudents(Integer groupId) {
        return studentService.allStudents(groupId);

    }

    public List<StudentInfoResponse> allRegisteredStudents(Integer groupId) {
        return studentService.allRegisteredStudents(groupId);
    }

    public void addStudentToGroup(Integer studentId, Boolean active) {
        studentService.addStudentToGroup(studentId, active);
    }


    public void addMoneyToStudentAccount(Integer studentId, BigDecimal amount) {
        studentBalanceService.addMoneyToStudentAccount(studentId, amount);

    }

    public void addNewExpense(ExpenseRequest request) {
        expenceService.addNewExpense(request);
    }

    public ContactResponse getContactInfoByUserId(Integer userId) {
        return contactService.getContactInfoByUserId(userId);
    }

    public ContactResponse getContactInfoByStudentId(Integer studentId) {
        return contactService.getContactInfoByStudentId(studentId);
    }
}
