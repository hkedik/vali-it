package com.example.demo.domain.user_student;

import com.example.demo.domain.student.*;
import com.example.demo.domain.user.User;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserStudentService {

    @Resource
    private UserStudentRepository userStudentRepository;

    @Resource
    private ValidationService validationService;

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private StudentMapper studentMapper;


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

    public List<StudentInfoResponse> findStudentsByUserId(Integer userId) {
        List<UserStudent> userStudents = userStudentRepository.findByUser_Id(userId);
        List<StudentInfoResponse> responses = new ArrayList<>();
        for (UserStudent userStudent : userStudents) {
            Optional<Student> student = studentRepository.findById(userStudent.getStudent().getId());
            validationService.isValidStudent(student, userStudent.getStudent().getId());
            responses.add(studentMapper.studentToStudentInfoResponse(student.get()));
    }
        return responses ;
}

}
