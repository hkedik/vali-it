package com.example.demo.domain.user_in_group;

import com.example.demo.domain.group_info.GroupInfo;
import com.example.demo.domain.user_role.UserRoleRepository;
import com.example.demo.domain.user_role.UserRoleService;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserInGroupService {

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private UserInGroupRepository userInGroupRepository;

    @Resource
    private ValidationService validationService;

    public Integer newGroupModerator(Integer userId, GroupInfo groupInfo) {
        UserInGroup userInGroup = new UserInGroup();
        userInGroup.setUserId(userId);
        userInGroup.setGroupInfoId(groupInfo.getId());
        userInGroup.setIsModerator(true);
        userInGroup.setIsActive(true);
        userInGroup.setDateActivated(LocalDate.now());
        userInGroupRepository.save(userInGroup);
        return userRoleService.userToModerator(userId);
    }

    public void parentGroupConnection(Integer parentId, Integer groupId) {
//    TODO: kahe lapsega vanema validatsioon
        UserInGroup userInGroup = new UserInGroup();
        userInGroup.setUserId(parentId);
        userInGroup.setGroupInfoId(groupId);
        userInGroup.setDateActivated(LocalDate.now());
        userInGroup.setIsActive(false);
        userInGroupRepository.save(userInGroup);
    }

    public List<UserInGroup> findGroupByUserId(Integer userId) {
        List<UserInGroup> userInGroups = userInGroupRepository.findByUserId(userId);
        return userInGroups;
    }
}
