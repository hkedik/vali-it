package com.example.demo.service;


import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.user.NewUserInfoRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/expense")
public class GroupExpenseController {

    @Resource
    private GroupExpenseService groupExpenseService;

    @Resource
    private ContactService contactService;

    @PostMapping("/new-user")
    @Operation(summary = "Add new user")
    public void addNewUser(@RequestBody NewUserInfoRequest newUserInfoRequest) {
        groupExpenseService.addNewUser(newUserInfoRequest);
        System.out.println("sergei");
    }



    @PostMapping

}

