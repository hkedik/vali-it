package com.example.demo.service.moderator;

import com.example.demo.domain.expence.ExpenseRequest;
import com.example.demo.domain.student.StudentInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {

    @Resource
    private ModeratorService moderatorService;


    @GetMapping("/all-students")
    @Operation(summary = "Get all students from your group")
    public List<StudentInfoResponse> allStudents(@RequestParam Integer groupId) {
        return moderatorService.allStudents(groupId);
    }

    @GetMapping("/all-registered-students")
    @Operation(summary = "Get all registered students from your group")
    public List<StudentInfoResponse> allRegisteredStudents(@RequestParam Integer groupId) {
        return moderatorService.allRegisteredStudents(groupId);
    }

    @PutMapping("/student-activation")
    @Operation(summary = "Add student to group")
    public void addStudentToGroup(@RequestParam Integer studentId, @RequestParam Boolean active) {
        moderatorService.addStudentToGroup(studentId, active);
    }

    @PutMapping("/money-deposit")
    @Operation(summary = "Add money to student account")
    public void addMoneyToStudentAccount(@RequestParam Integer studentId, @RequestParam BigDecimal amount) {
        moderatorService.addMoneyToStudentAccount(studentId, amount);
    }

    @PostMapping("/new-expense")
    @Operation(summary = "Add new expense")
    public void addNewExpense(@RequestBody ExpenseRequest request) {
        moderatorService.addNewExpense(request);
    }

}
