package com.example.demo.domain.user_student;

import com.example.demo.domain.student.Student;
import com.example.demo.domain.user.User;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserStudentService {

    @Resource
    private UserStudentRepository userStudentRepository;

    @Resource
    private ValidationService validationService;


    public void addStudentUserRelationship(Student student, User user) {
        UserStudent userStudent = new UserStudent();
        userStudent.setStudent(student);
        userStudent.setUser(user);
        userStudentRepository.save(userStudent);
    }

    public Integer getParentId(Integer studentId) {
        Optional<UserStudent> byStudentId = userStudentRepository.findByStudentId(studentId);
        validationService.isValidUserStudentRelationship(byStudentId, studentId);
        UserStudent userStudent = byStudentId.get();
        return userStudent.getUser().getId();

    }
}
