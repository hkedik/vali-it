package com.example.demo.domain.user;


import com.example.demo.domain.contact.Contact;
import com.example.demo.domain.contact.ContactRepository;

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

    public void addNewUser(NewUserInfoRequest newUserInfoRequest) {

        Contact contact = userMapper.requestToContact(newUserInfoRequest);
        contactRepository.save(contact);
        Contact foundContact = contactRepository.findByEmail(newUserInfoRequest.getContactEmail());
        User user = userMapper.requestToUser(newUserInfoRequest);
        user.setContact(foundContact);
        userRepository.save(user);

    }

    public boolean logIn(String userName, String password) {
        Optional<User> user = userRepository.loginControl(userName, password);
        if (user.isEmpty()) {
            return false;
        }
        return true;
    }
}

