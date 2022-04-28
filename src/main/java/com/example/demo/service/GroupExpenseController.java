package com.example.demo.service;


import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.group_info.GroupInfoRequest;
import com.example.demo.domain.student.NewStudentRequest;
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
    public void addNewUser(@RequestBody NewUserInfoRequest newUserInfoRequest) {
        groupExpenseService.addNewUser(newUserInfoRequest);
        System.out.println("sergei");
    }


    @PostMapping("/new-group")
    @Operation(summary = "Add new group")
    public void addGroup(@RequestBody GroupInfoRequest groupInfoRequest) {
        groupExpenseService.addNewGroup(groupInfoRequest);
    }

    @GetMapping("/login")
    @Operation(summary = "Log in")
    public boolean logIn(@RequestParam String userName, @RequestParam String password) {
        return groupExpenseService.logIn(userName, password);
    }

    @PostMapping("/new-student")
    @Operation(summary = "Add new student")
    public void addNewStudent(@RequestBody NewStudentRequest request ) {
        groupExpenseService.addNewStudent(request);
    }
}

