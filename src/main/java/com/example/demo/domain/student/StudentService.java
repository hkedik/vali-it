package com.example.demo.domain.student;

import com.example.demo.domain.group_info.GroupInfoRepository;
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


    public void addNewStudent(NewStudentRequest request) {
        Student student = studentMapper.requestToStudent(request);
        student.setGroupInfo(groupInfoRepository.getById(1));
        studentRepository.save(student);
    }
}
