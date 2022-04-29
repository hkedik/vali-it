package com.example.demo.service.moderator;

import com.example.demo.domain.group_info.GroupInfoService;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModeratorService {

    @Resource
    private GroupInfoService groupInfoService;

    @Resource
    StudentService studentService;


    public void addStudentToGroup(Student student) {
        groupInfoService.addStudentToGroup(student);
    }

    public List<Student> getYourGroupStudents(Integer groupId) {
        return studentService.getYourGroupStudents(groupId);
    }

    public List<Student> getYourGroupUnregisteredStudents(Integer groupId) {
        return studentService.getYourGroupUnregisteredStudents(groupId);
    }
}
