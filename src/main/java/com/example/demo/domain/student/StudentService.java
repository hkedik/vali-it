package com.example.demo.domain.student;

import com.example.demo.domain.group_info.GroupInfoRepository;
import com.example.demo.domain.user.UserRepository;
import com.example.demo.domain.user_student.UserStudent;
import com.example.demo.domain.user_student.UserStudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


    public StudentInfoResponse addNewStudent(StudentInfoRequest request) {
        Student student = studentMapper.requestToStudent(request);
        student.setGroupInfo(groupInfoRepository.getById(request.getGroupInfoId()));
        Student savedStudent = studentRepository.save(student);
        UserStudent userStudent = new UserStudent();
        userStudent.setStudent(savedStudent);
        userStudent.setUser(userRepository.getById(request.getParentUserId()));
        userStudentRepository.save(userStudent);
        return studentMapper.studentToStudentInfoResponse(savedStudent);
    }

    public List<StudentInfoResponse> allStudents(Integer groupId) {
        List<Student> all = studentRepository.findByGroupInfo_Id(groupId);
        return studentMapper.studentToStudentInfoResponse(all);

    }

    public List<StudentInfoResponse> allRegisteredStudents(Integer groupId) {
        List<Student> registeredStudents = studentRepository.findRegisteredStudents(groupId);
        return studentMapper.studentToStudentInfoResponse(registeredStudents);
    }
}
