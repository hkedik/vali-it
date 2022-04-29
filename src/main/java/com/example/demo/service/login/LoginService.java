package com.example.demo.service.login;

import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import com.example.demo.domain.user_role.UserRole;
import com.example.demo.domain.user_role.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    public LoginResponse logIn(String userName, String password) {
        User validUser = userService.getValidUser(userName, password);
        UserRole userRole = userRoleService.getUserRole(validUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(validUser.getId());
        loginResponse.setUserRoleId(userRole.getRole().getId());
        return loginResponse;
    }
}
