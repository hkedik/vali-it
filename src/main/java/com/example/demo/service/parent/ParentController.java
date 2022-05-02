package com.example.demo.service.parent;

import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.student.StudentInfoResponse;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class ParentController {

    @Resource
    private ParentService parentService;


    @PostMapping("/new-student")
    @Operation(summary = "Add new student")
    public StudentInfoResponse addNewStudent(@RequestBody StudentInfoRequest request) {
        return parentService.addNewStudent(request);
    }
}
