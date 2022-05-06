package com.example.demo.service.moderator;

import com.example.demo.domain.contact.ContactResponse;
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
    public List<StudentInfoResponse> allYourGroupStudents(@RequestParam Integer groupId) {
        return moderatorService.allYourGroupStudents(groupId);
    }

    @GetMapping("/all-registered-students")
    @Operation(summary = "Get all registered students from your group")
    public List<StudentInfoResponse> allRegisteredStudents(@RequestParam Integer groupId) {
        return moderatorService.allRegisteredStudents(groupId);
    }

    @GetMapping("/student-activation")
    @Operation(summary = "Add student to group")
    public void addStudentToGroup(@RequestParam Integer id) {
        moderatorService.addStudentToGroup(id);
    }

    @GetMapping("/student-deactivation")
    @Operation(summary = "Remove student from group")
    public void removeStudentFromGroup(@RequestParam Integer id) {
        moderatorService.removeStudentFromGroup(id);
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

    @GetMapping("/user-contact-info")
    @Operation(summary = "Get contact info by user id")
    public ContactResponse getContactInfoByUserId(@RequestParam Integer userId) {
        return moderatorService.getContactInfoByUserId(userId);
    }

    @GetMapping("/user-contact-by-student-id")
    @Operation(summary = "Find user contact by student id")
    public ContactResponse getContactInfoByStudentId(@RequestParam Integer studentId) {
        return moderatorService.getContactInfoByStudentId(studentId);
    }
}
