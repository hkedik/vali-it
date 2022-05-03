package com.example.demo.service.parent;

import com.example.demo.domain.group_balance.GroupBalanceResponse;
import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.group_info.GroupInfoResponse;
import com.example.demo.domain.group_info.GroupInfoService;
import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.student.StudentInfoResponse;
import com.example.demo.domain.student.StudentService;

import com.example.demo.domain.student_balance.StudentBalanceResponse;
import com.example.demo.domain.student_balance.StudentBalanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ParentService {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentBalanceService studentBalanceService;

    @Resource
    private GroupBalanceService groupBalanceService;

    @Resource
    private GroupInfoService groupInfoService;

    public void addNewStudent(StudentInfoRequest request) {
        studentService.addNewStudent(request);
    }

    public StudentBalanceResponse findStudentBalanceById(Integer id) {
        return studentBalanceService.findStudentBalanceById(id);
    }

    public GroupBalanceResponse getGroupBalance(Integer groupId) {
            return groupBalanceService.getGroupBalance(groupId);
    }

    public GroupInfoResponse findGroupByName(String groupName) {
            return groupInfoService.findGroupByName(groupName);
    }
}
