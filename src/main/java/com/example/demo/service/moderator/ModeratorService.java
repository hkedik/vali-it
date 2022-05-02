package com.example.demo.service.moderator;

import com.example.demo.domain.student.StudentInfoResponse;
import com.example.demo.domain.student.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModeratorService {

    @Resource
    private StudentService studentService;


    public List<StudentInfoResponse> allStudents(Integer groupId) {
        return studentService.allStudents(groupId);

    }

    public List<StudentInfoResponse> allRegisteredStudents(Integer groupId) {
        return studentService.allRegisteredStudents(groupId);
    }
}
