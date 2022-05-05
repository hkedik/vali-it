package com.example.demo.domain.user;


import com.example.demo.domain.contact.Contact;
import com.example.demo.domain.contact.ContactRepository;

import com.example.demo.domain.contact.ContactService;
import com.example.demo.domain.role.RoleRepository;
import com.example.demo.domain.user_role.UserRole;
import com.example.demo.domain.user_role.UserRoleRepository;
import com.example.demo.domain.user_role.UserRoleService;
import com.example.demo.service.login.LoginResponse;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ContactRepository contactRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserRoleRepository userRoleRepository;

    @Resource
    private ValidationService validationService;

    @Resource
    private ContactService contactService;

    @Resource
    private UserRoleService userRoleService;

    public LoginResponse addNewUser(NewUserInfoRequest newUserInfoRequest) {
        Contact contact = contactService.addNewContact(newUserInfoRequest);
        User user = userMapper.requestToUser(newUserInfoRequest);
        user.setContact(contact);
        userRepository.save(user);
        userRoleService.addNewUserRole(user);
        LoginResponse response = new LoginResponse();
        response.setUserId(user.getId());
        response.setRoleId(userRoleService.getRole(user.getId()));
        return response;
    }

    public User getValidUser(String userName, String password) {
        Optional<User> user = userRepository.loginControl(userName, password);
        validationService.isLoginOk(user);
        return user.get();
    }

    public User getValidUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        validationService.isValidUser(userId, user);
        return user.get();
    }
}

