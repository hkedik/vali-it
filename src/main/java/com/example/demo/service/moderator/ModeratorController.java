package com.example.demo.service.moderator;

import com.example.demo.domain.student.Student;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {

    @Resource
    private ModeratorService moderatorService;


    @PostMapping("/student-to-group")
    @Operation(summary = "Add student to group")
    public void addStudentToGroup(@RequestBody Student student) {
        moderatorService.addStudentToGroup(student);
    }

    @GetMapping("/new-students")
    @Operation(summary = "Show your group students")
    public List<Student> getYourGroupStudents(Integer groupId) {
        return moderatorService.getYourGroupStudents(groupId);
    }
    @GetMapping("/unregistered-students")
    @Operation(summary = "Show your group unregistered students")
    public List<Student> getYourGroupUnregisteredStudents(Integer groupId) {
        return moderatorService.getYourGroupUnregisteredStudents(groupId);
    }

}
