package com.example.demo.domain.user_role;

import com.example.demo.domain.role.RoleRepository;
import com.example.demo.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;

    @Resource
    private RoleRepository roleRepository;

    public UserRole getUserRole(User validUser) {
        return userRoleRepository.findByUserId(validUser.getId());
    }

    public void userToModerator(Integer userId) {
        UserRole toModeratorUser = userRoleRepository.findByUserId(userId);
        toModeratorUser.setRole(roleRepository.getById(4));
        userRoleRepository.save(toModeratorUser);
    }

    public void addNewUserRole(User user) {
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(roleRepository.getById(3));
        userRoleRepository.save(userRole);
    }
}
