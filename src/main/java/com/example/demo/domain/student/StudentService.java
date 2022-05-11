package com.example.demo.domain.student;

import com.example.demo.domain.expense.Expense;
import com.example.demo.domain.expense.ExpenseRequest;
import com.example.demo.domain.group_info.GroupInfoService;
import com.example.demo.domain.student_balance.StudentBalance;
import com.example.demo.domain.student_balance.StudentBalanceService;
import com.example.demo.domain.user_role.student_balance_log.StudentBalanceLogRequest;
import com.example.demo.domain.user_role.student_balance_log.StudentBalanceLogService;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.user_in_group.UserInGroupService;
import com.example.demo.domain.user_student.UserStudentService;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Resource
    private ValidationService validationService;

    @Resource
    private UserInGroupService userInGroupService;

    @Resource
    private StudentBalanceService studentBalanceService;

    @Resource
    private StudentBalanceLogService studentBalanceLogService;


    public void addNewStudent(StudentInfoRequest request) {
        Student student = studentMapper.requestToStudent(request);
        student.setGroupInfo(groupInfoService.getGroupById(request.getGroupInfoId()));
        studentRepository.save(student);
        User user = userService.getValidUser(request.getParentUserId());
        userStudentService.addStudentUserRelationship(student, user);
        studentBalanceService.addNewStudentBalance(student,student.getGroupInfo().getId());
        userInGroupService.addNewParentGroupConnection(request);

    }


    public List<StudentInfoResponse> allYourGroupStudents(Integer groupId) {
        List<Student> all = studentRepository.findByGroupInfo_Id(groupId);
        List<StudentInfoResponse> responses = new ArrayList<>();
        for (Student student : all) {
            StudentInfoResponse response = studentMapper.studentToStudentInfoResponse(student);
            StudentBalance balance = studentBalanceService.findStudentBalanceByStudentId(student.getId());
            response.setStudentBalanceAmount(balance.getBalance());
            if (response.getActive().equals(true)) {
                responses.add(response);
            }

        }
        return responses;
    }

    public List<StudentInfoResponse> allRegisteredStudents(Integer groupId) {
        List<Student> registeredStudents = studentRepository.findRegisteredStudents(groupId);

        return studentMapper.studentToStudentInfoResponse(registeredStudents);
    }

    public void addStudentToGroup(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        validationService.isValidStudent(student, id);
        Student registeredStudent = student.get();
        registeredStudent.setActive(true);
        studentRepository.save(registeredStudent);
        Integer parentId = userStudentService.getParentId(id);
        userInGroupService.activateParentGroupConnection(parentId);
    }

    public void changeStudentBalance(ExpenseRequest request, Expense expense) {
        List<StudentInfoResponse> students = request.getStudents();
        double numberOfStudents = students.size();

//        double counter  = 0;
//        List<StudentInfoResponse> selectedStudents = new ArrayList<>();
//        for (StudentInfoResponse student : students) {
//            if(student.getSelected()) {
//                selectedStudents.add(student);
//                counter++;
//            }
//        }

        BigDecimal amount = request.getAmount();
        BigDecimal amountPerStudent = amount.divide(BigDecimal.valueOf(numberOfStudents));

        for (StudentInfoResponse student : students) {
            StudentBalance studentBalance = studentBalanceService.creditStudentBalance(student, amountPerStudent);
            StudentBalanceLogRequest logRequest = new StudentBalanceLogRequest();
            logRequest.setStudentBalance(studentBalance);
            logRequest.setExpense(expense);
            logRequest.setAmount(amountPerStudent);
            studentBalanceLogService.addCreditBalanceLog(logRequest);
        }
    }

    public void removeStudentFromGroup(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        validationService.isValidStudent(student, id);
        Student registeredStudent = student.get();
        registeredStudent.setActive(false);
        studentRepository.save(registeredStudent);
        Integer parentId = userStudentService.getParentId(id);
        userInGroupService.deactivateParentGroupConnection(parentId);
    }

    public void addStudentsToGroup(List<StudentInfoResponse> request) {
        for (StudentInfoResponse student : request) {
            if (student.getSelected().equals(true)) {
                Student foundStudent = studentRepository.getById(student.getStudentId());
                foundStudent.setActive(true);
                studentRepository.save(foundStudent);
                Integer parentId = userStudentService.getParentId(student.getStudentId());
                userInGroupService.activateParentGroupConnection(parentId);
            }
        }
    }

    public void removeStudentsFromGroup(List<StudentInfoResponse> request) {
        for (StudentInfoResponse student : request) {
            if (student.getSelected().equals(true)) {
                Student foundStudent = studentRepository.getById(student.getStudentId());
                foundStudent.setActive(false);
                studentRepository.save(foundStudent);
                Integer parentId = userStudentService.getParentId(student.getStudentId());
                userInGroupService.deactivateParentGroupConnection(parentId);
            }
        }
    }

}
