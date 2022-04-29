package com.example.demo.domain.student;

import com.example.demo.domain.group_info.GroupInfoRepository;
import com.example.demo.domain.user.UserRepository;
import com.example.demo.domain.user_student.UserStudent;
import com.example.demo.domain.user_student.UserStudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private GroupInfoRepository groupInfoRepository;

    @Resource
    private UserStudentRepository userStudentRepository;

    @Resource
    private UserRepository userRepository;


    public void addNewStudent(StudentInfoRequest request) {
        Student student = studentMapper.requestToStudent(request);
        student.setGroupInfo(groupInfoRepository.getById(request.getGroupInfoId()));
        studentRepository.save(student);
        UserStudent userStudent = new UserStudent();
        userStudent.setStudent(student);
        userStudent.setUser(userRepository.getById(request.getParentUserId()));
        userStudentRepository.save(userStudent);
    }
}
