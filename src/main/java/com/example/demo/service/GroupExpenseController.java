package com.example.demo.service;


import com.example.demo.domain.group_info.GroupInfoRequest;
import com.example.demo.domain.group_info.GroupInfoResponse;
import com.example.demo.domain.student.StudentInfoRequest;
import com.example.demo.domain.user.NewUserInfoRequest;
import com.example.demo.service.login.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class GroupExpenseController {

    @Resource
    private GroupExpenseService groupExpenseService;


    @PostMapping("/new-user")
    @Operation(summary = "Add new user")
    public LoginResponse addNewUser(@RequestBody NewUserInfoRequest request) {
       return groupExpenseService.addNewUser(request);
    }


    @PostMapping("/new-group")
    @Operation(summary = "Add new group")
    public Integer addGroup(@RequestBody GroupInfoRequest request)  {
        return groupExpenseService.addNewGroup(request);
    }

    @GetMapping("/group-by-user-id")
    @Operation(summary = "Find group by user id")
    public List<GroupInfoResponse> findGroupByUserId(Integer userId) {
        return groupExpenseService.findGroupByUserId(userId);
    }


}

