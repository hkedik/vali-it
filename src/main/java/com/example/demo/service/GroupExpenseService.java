package com.example.demo.service;


import com.example.demo.domain.contact.ContactDto;
import com.example.demo.domain.group_info.GroupInfoRequest;
import com.example.demo.domain.group_info.GroupInfoService;
import com.example.demo.domain.user.NewUserInfoRequest;
import com.example.demo.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GroupExpenseService {
    
    
    @Resource 
    private UserService userService;

    @Resource
    private GroupInfoService groupInfoService;

    public void addNewUser(NewUserInfoRequest newUserInfoRequest) {
        userService.addNewUser(newUserInfoRequest);
    }

    public void addNewGroup(GroupInfoRequest groupInfoRequest) {
        groupInfoService.addNewGroup(groupInfoRequest);

    }

    public boolean logIn(String userName, String password) {
       return userService.logIn(userName, password);
    }
}
