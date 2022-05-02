package com.example.demo.domain.student;

import com.example.demo.domain.group_info.GroupInfoRepository;
import com.example.demo.domain.group_info.GroupInfoService;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserRepository;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.user_student.UserStudent;
import com.example.demo.domain.user_student.UserStudentRepository;
import com.example.demo.domain.user_student.UserStudentService;
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
    private GroupInfoService groupInfoService;

    @Resource
    private UserStudentService userStudentService;

    @Resource
    private UserService userService;


    public void addNewStudent(StudentInfoRequest request) {
        Student student = studentMapper.requestToStudent(request);
        student.setGroupInfo(groupInfoService.getGroupById(request.getGroupInfoId()));
        studentRepository.save(student);
        User user = userService.getValidUser(request.getParentUserId());
        userStudentService.addStudentUserRelationship(student, user);
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
