package com.example.demo.service.parent;

import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.student_balance.StudentBalanceResponse;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @GetMapping("/studentBalance")
    @Operation(summary = "student balance")
    public StudentBalanceResponse findStudentBalanceById(@RequestParam Integer id) {
        return parentService.findStudentBalanceById(id);

    }
}
