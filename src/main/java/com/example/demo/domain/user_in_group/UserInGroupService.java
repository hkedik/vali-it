package com.example.demo.domain.user_in_group;

import com.example.demo.domain.group_info.GroupInfo;
import com.example.demo.domain.student.StudentInfoRequest;
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

    public void deactivateParentGroupConnection(Integer parentId, Integer groupId) {
//    TODO: kahe lapsega vanema validatsioon
        UserInGroup connection = userInGroupRepository.getByUserIdAndGroupInfoId(parentId, groupId);
        connection.setIsActive(false);
        connection.setDateActivated(LocalDate.now());
        userInGroupRepository.save(connection);
    }

    public List<UserInGroup> findGroupByUserId(Integer userId) {
        List<UserInGroup> userInGroups = userInGroupRepository.findByUserId(userId);
        return userInGroups;
    }

    public void activateParentGroupConnection(Integer parentId, Integer groupId) {
        UserInGroup connection = userInGroupRepository.getByUserIdAndGroupInfoId(parentId, groupId);
        connection.setIsActive(true);
        connection.setDateActivated(LocalDate.now());
        userInGroupRepository.save(connection);
    }

    public void addNewParentGroupConnection(StudentInfoRequest request) {
        Optional<UserInGroup> connectionControl = userInGroupRepository.findByUserIdAndGroupInfoId(request.getParentUserId(), request.getGroupInfoId());
        if (connectionControl.isEmpty()) {
            UserInGroup parentInGroup = new UserInGroup();
            parentInGroup.setGroupInfoId(request.getGroupInfoId());
            parentInGroup.setUserId(request.getParentUserId());
            parentInGroup.setDateActivated(LocalDate.now());
            parentInGroup.setIsActive(false);
            parentInGroup.setIsModerator(false);
            userInGroupRepository.save(parentInGroup);
        }
    }

    public Boolean findModeratorControl(Integer groupId, Integer userId) {
        UserInGroup byIdAndUserId = userInGroupRepository.findByGroupInfoIdAndUserId(groupId, userId);
        return byIdAndUserId.getIsModerator();
    }
}
