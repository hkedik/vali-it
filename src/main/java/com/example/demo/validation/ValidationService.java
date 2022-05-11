package com.example.demo.validation;

import com.example.demo.domain.contact.Contact;
import com.example.demo.domain.group_balance.GroupBalance;
import com.example.demo.domain.group_info.GroupInfo;
import com.example.demo.domain.student.Student;
import com.example.demo.domain.student_balance.StudentBalance;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user_in_group.UserInGroup;
import com.example.demo.domain.user_student.UserStudent;
import com.example.demo.infrastructure.exception.BusinessException;
import com.example.demo.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {

    public static final String INCORRECT_DETAILS = "Incorrect details";
    public static final String NOT_ALLOWED_LOG_IN_DETAILS = "Not allowed log-in details";

    public void isLoginOk(Optional<User> user) {
        if (user.isEmpty()) {
            throw new BusinessException(INCORRECT_DETAILS, NOT_ALLOWED_LOG_IN_DETAILS);
        }
    }

    public void groupExists(Optional<GroupInfo> group) {
        if (group.isPresent()) {
            throw new BusinessException("Group with that name already exists", "Change the group name");
        }
    }

    public void isValidUser(Integer userId, Optional<User> user) {
        if (user.isEmpty()) {
            throw new DataNotFoundException("User does not exist", "User with userId: " + userId + " does not exist");
        }
    }

    public void isValidGroup(Optional<GroupInfo> groupInfo, Integer groupInfoId) {
        if (groupInfo.isEmpty()) {
            throw new DataNotFoundException("Group does not exist", "Group with groupId " + groupInfoId + " does not exist");
        }
    }

    public void isValidStudent(Optional<Student> student, Integer studentId) {
        if (student.isEmpty()) {
            throw new DataNotFoundException("Student does not exist", "Student with studentId " + studentId + " does not exist");
        }
    }

    public void isValidUserStudentRelationship(Optional<UserStudent> byStudentId, Integer studentId) {
        if (byStudentId.isEmpty()) {
            throw new DataNotFoundException("ERROR ERROR ERROR nr. ", "" + studentId );
        }
    }

    public void isValidGroupBalance(Optional<GroupBalance> byGroupInfo_id) {
        if (byGroupInfo_id.isEmpty()) {
            throw new DataNotFoundException("ERROR ERROR ERROR nr. ", "" + byGroupInfo_id );
        }
    }

    public void isValidStudentBalance(Optional<StudentBalance> byStudent_id) {
        if (byStudent_id.isEmpty()) {
            throw new DataNotFoundException("ERROR ERROR ERROR nr. ", "" + byStudent_id );
        }
    }

    public void enteredGroupExists(Optional<GroupInfo> byGroupName, String groupName) {
        if (byGroupName.isEmpty()) {
            throw new DataNotFoundException("This group does not exist", "Group with a name " + groupName + " does not exist.");
        }
    }

    public void enteredGroupExistsByGroupId(Optional<GroupInfo> groupInfoResponse, Integer groupId) {
        if (groupInfoResponse.isEmpty()) {
            throw new DataNotFoundException("This group does not exist", "Group with a ID " + groupId + " does not exist.");
        }
    }

    public void isValidContact(Optional<Contact> contact) {
        if (contact.isEmpty()) {
            throw new DataNotFoundException("Contact info does not exist", "Problem with student id");
        }
    }

    public void studentExist(Optional<UserStudent> userStudent) {
        if (userStudent.isEmpty()) {
            throw new BusinessException("Student is not found", "Add new kid");
        }

    }

    public void isValidUserGroup(Optional<UserInGroup> group) {
        if (group.isEmpty()) {
            throw new DataNotFoundException("Group is not found", "Control info");
        }
    }

    public void isAlreadyConnected(Optional<UserInGroup> connectionControl) {
        if (connectionControl.isPresent()) {
            throw new BusinessException("Olete juba gruppiga seotud", "OK");
        }
    }


//    public void accountExists(String accountNumber, Optional<Account> account) {
//        if (account.isEmpty()) {
//            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot kontonumbriga " + accountNumber + " ei leitud");
//        }
//    }
//
//    public void isValidDepositAmount(Integer amount) {
//        // productionsis tuleks see väärtus andmebaasist
//        Integer limit = 5000;
//        if (amount > limit) {
//            throw new BusinessException(DEPOSIT_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
//        }
//    }
//
//    public void isValidWithdrawAmount(Integer amount) {
//        // productionsis tuleks see väärtus andmebaasist
//        Integer limit = 15000;
//        if (amount > limit) {
//            throw new BusinessException(WITHDRAW_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
//        }
//    }
//
//    public void isWithinBalance(Integer balance, Integer amount) {
//        if (amount > balance) {
//            throw new BusinessException(INSUFFICIENT_FUNDS, "Summa €" + amount + " ületab kontojääki €" + balance);
//        }
//    }
//
//    public void customerExists(Integer customerId, Optional<Customer> customer) {
//        if (customer.isEmpty()) {
//            throw new DataNotFoundException(CUSTOMER_NOT_EXISTS, "Klienti ID'ga " + customerId + " ei leitud");
//        }
//    }
//
//    public void isikukoodAlreadyExists(String isikukood, boolean customerExists) {
//        if (customerExists) {
//            throw new BusinessException(ISIKUKOOD_ALREADY_TAKEN, "Isikukood " + isikukood + " on juba kasutusel");
//        }
//    }
}
