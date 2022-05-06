package com.example.demo.service.parent;

import com.example.demo.domain.contact.ContactRequest;
import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.group_balance.GroupBalanceResponse;
import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.group_info.GroupInfoResponse;
import com.example.demo.domain.group_info.GroupInfoService;
import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.student.StudentInfoResponse;
import com.example.demo.domain.student.StudentService;

import com.example.demo.domain.student_balance.StudentBalanceResponse;
import com.example.demo.domain.student_balance.StudentBalanceService;
import com.example.demo.domain.student_balance_log.StudentBalanceLogResponse;
import com.example.demo.domain.student_balance_log.StudentBalanceLogService;
import com.example.demo.domain.user_student.UserStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ContactService contactService;

    @Resource
    private UserStudentService userStudentService;

    @Resource
    private StudentBalanceLogService studentBalanceLogService;



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

    public void updateParentContactInfo(ContactRequest request) {
        contactService.updateParentContactInfo(request);
    }

    public List<StudentInfoResponse> findStudentsByUserId(Integer userId) {
        return userStudentService.findStudentsByUserId(userId);
    }

    public List<StudentBalanceLogResponse> findStudentBalanceLogsByStudentId(Integer studentId) {
        return studentBalanceLogService.findStudentBalanceLogsByStudentId(studentId);
    }
}
