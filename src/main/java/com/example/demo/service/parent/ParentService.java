package com.example.demo.service.parent;

import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.student.StudentInfoResponse;
import com.example.demo.domain.student.StudentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ParentService {

    @Resource
    private StudentService studentService;

    public StudentInfoResponse addNewStudent(StudentInfoRequest request) {
        return studentService.addNewStudent(request);
    }
}
