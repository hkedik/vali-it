package com.example.demo.domain.user_student;

import com.example.demo.domain.student.Student;
import com.example.demo.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserStudentService {

    @Resource
    private UserStudentRepository userStudentRepository;

    public void addStudentUserRelationship(Student student, User user) {
        UserStudent userStudent = new UserStudent();
        userStudent.setStudent(student);
        userStudent.setUser(user);
        userStudentRepository.save(userStudent);
    }

}
