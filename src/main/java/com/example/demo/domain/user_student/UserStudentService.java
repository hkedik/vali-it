package com.example.demo.domain.user_student;

import com.example.demo.domain.group_balance.GroupBalance;
import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.student.*;
import com.example.demo.domain.student_balance.StudentBalance;
import com.example.demo.domain.student_balance.StudentBalanceService;
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

    @Resource
    private StudentBalanceService studentBalanceService;

    @Resource
    private GroupBalanceService groupBalanceService;


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
            StudentInfoResponse response = studentMapper.studentToStudentInfoResponse(student.get());
            StudentBalance balance = studentBalanceService.findStudentBalanceByStudentId(userStudent.getStudent().getId());
            response.setStudentBalanceAmount(balance.getBalance());
            GroupBalance groupBalance = groupBalanceService.findGroupBalanceByGroupId(student.get().getGroupInfo().getId());
            response.setGroupBalanceAmount(groupBalance.getBalance());
            responses.add(response);
    }
        return responses ;
}

}
