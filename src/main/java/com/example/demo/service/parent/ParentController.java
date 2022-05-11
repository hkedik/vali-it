package com.example.demo.service.parent;

import com.example.demo.domain.group_balance.GroupBalanceResponse;
import com.example.demo.domain.group_info.GroupInfoResponse;
import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.student.StudentInfoResponse;
import com.example.demo.domain.student_balance.StudentBalanceResponse;
import com.example.demo.domain.user_role.student_balance_log.StudentBalanceLogResponse;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ParentController {

    @Resource
    private ParentService parentService;

    @PostMapping("/new-student")
    @Operation(summary = "Add new student")
    public void addNewStudent(@RequestBody StudentInfoRequest request) {
        parentService.addNewStudent(request);
    }

    @GetMapping("/student-balance")
    @Operation(summary = "student balance")
    public StudentBalanceResponse findStudentBalanceById(@RequestParam Integer id) {
        return parentService.findStudentBalanceById(id);
    }

    @GetMapping("/group-balance")
    @Operation(summary = "Show group balance")
    public GroupBalanceResponse getGroupBalance(@RequestParam Integer groupId) {
        return parentService.getGroupBalance(groupId);
    }

    @GetMapping("/group-by-name")
    @Operation(summary = "Find group by name")
    public GroupInfoResponse findGroupByName(@RequestParam String groupName) {
        return parentService.findGroupByName(groupName);
    }

    @GetMapping("/student-by-user-id")
    @Operation(summary = "Find all parent students")
    public List<StudentInfoResponse> findStudentsByUserId(@RequestParam Integer userId) {
        return parentService.findStudentsByUserId(userId);
    }

    @GetMapping("/student-balance-log/student-id")
    @Operation(summary = "Find student logs by student id")
    public List<StudentBalanceLogResponse> findStudentBalanceLogsByStudentId(@RequestParam Integer studentId) {
        return parentService.findStudentBalanceLogsByStudentId(studentId);
    }


}
