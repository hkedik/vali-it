package com.example.demo.service;


import com.example.demo.domain.contact.ContactDto;
import com.example.demo.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GroupExpenseService {
    
    
    @Resource 
    private UserService userService;
    
    public void addNewUser(String username, String password) {
        userService.addNewUser(username, password);
    }

    public void addNewContactInfo(ContactDto contactDto) {
    }
}
