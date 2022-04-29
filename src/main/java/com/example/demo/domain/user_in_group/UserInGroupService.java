package com.example.demo.domain.user_in_group;

import com.example.demo.domain.group_info.GroupInfo;
import com.example.demo.domain.user_role.UserRoleRepository;
import com.example.demo.domain.user_role.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class UserInGroupService {

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private UserInGroupRepository userInGroupRepository;

    public void newGroupModerator(Integer userId, GroupInfo groupInfo) {
        UserInGroup userInGroup = new UserInGroup();
        userInGroup.setUserId(userId);
        userInGroup.setGroupInfoId(groupInfo.getId());
        userInGroup.setIsModerator(true);
        userInGroup.setIsActive(true);
        userInGroup.setDateActivated(LocalDate.now());
        userInGroupRepository.save(userInGroup);
        userRoleService.userToModerator(userId);
    }
}
