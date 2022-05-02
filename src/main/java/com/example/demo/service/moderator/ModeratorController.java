package com.example.demo.service.moderator;

import com.example.demo.domain.student.StudentInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

}
