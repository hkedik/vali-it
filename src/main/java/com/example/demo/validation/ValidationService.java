package com.example.demo.validation;

import com.example.demo.domain.group_info.GroupInfo;
import com.example.demo.domain.user.User;
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
