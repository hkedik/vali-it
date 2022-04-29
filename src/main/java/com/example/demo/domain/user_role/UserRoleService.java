package com.example.demo.domain.user_role;

import com.example.demo.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;

    public UserRole getUserRole(User validUser) {
        return userRoleRepository.findByUserId(validUser.getId());
    }
}
