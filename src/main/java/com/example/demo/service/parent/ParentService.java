package com.example.demo.service.parent;

import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.student.StudentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ParentService {

    @Resource
    private StudentService studentService;

    public void addNewStudent(StudentInfoRequest request) {
        studentService.addNewStudent(request);
    }
}