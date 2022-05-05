package com.example.demo.service;


import com.example.demo.domain.group_info.GroupInfoRequest;
import com.example.demo.domain.group_info.GroupInfoService;
import com.example.demo.domain.user.NewUserInfoRequest;
import com.example.demo.domain.user.UserService;
import com.example.demo.service.login.LoginResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GroupExpenseService {


    @Resource
    private UserService userService;

    @Resource
    private GroupInfoService groupInfoService;


    public LoginResponse addNewUser(NewUserInfoRequest request) {
       return userService.addNewUser(request);
    }

    public Integer addNewGroup(GroupInfoRequest request) {
       return groupInfoService.addNewGroup(request);
    }

}
