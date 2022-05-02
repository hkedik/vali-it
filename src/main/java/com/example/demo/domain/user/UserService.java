package com.example.demo.domain.user;


import com.example.demo.domain.contact.Contact;
import com.example.demo.domain.contact.ContactRepository;

import com.example.demo.domain.role.RoleRepository;
import com.example.demo.domain.user_role.UserRole;
import com.example.demo.domain.user_role.UserRoleRepository;
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

    public void addNewUser(NewUserInfoRequest newUserInfoRequest) {

        Contact contact = userMapper.requestToContact(newUserInfoRequest);
        contactRepository.save(contact);
        Contact foundContact = contactRepository.findByEmail(newUserInfoRequest.getContactEmail());
        User user = userMapper.requestToUser(newUserInfoRequest);
        user.setContact(foundContact);
        userRepository.save(user);
        UserRole newUserRole = new UserRole();
        newUserRole.setUser(user);
        newUserRole.setRole(roleRepository.getById(3));
        userRoleRepository.save(newUserRole);
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

