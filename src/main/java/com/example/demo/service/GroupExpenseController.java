package com.example.demo.service;


import com.example.demo.domain.group_info.GroupInfoRequest;
import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.user.NewUserInfoRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/expense")
public class GroupExpenseController {

    @Resource
    private GroupExpenseService groupExpenseService;



    @PostMapping("/new-user")
    @Operation(summary = "Add new user")
    public void addNewUser(@RequestBody NewUserInfoRequest request) {
        groupExpenseService.addNewUser(request);
    }


    @PostMapping("/new-group")
    @Operation(summary = "Add new group")
    public void addGroup(@RequestBody GroupInfoRequest request) {
        groupExpenseService.addNewGroup(request);
    }


}

