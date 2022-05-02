package com.example.demo.domain.group_info;


import com.example.demo.domain.group_balance.GroupBalanceService;
import com.example.demo.domain.user_in_group.UserInGroupService;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Optional;

@Service
public class GroupInfoService {

    @Resource
    private GroupInfoMapper groupInfoMapper;

    @Resource
    private GroupInfoRepository groupInfoRepository;

    @Resource
    private ValidationService validationService;

    @Resource
    private UserInGroupService userInGroupService;

    @Resource
    private GroupBalanceService groupBalanceService;


    public void addNewGroup(GroupInfoRequest request) {
        Optional<GroupInfo> group = groupInfoRepository.findByGroupName(request.getGroupName());
        validationService.groupExists(group);
        GroupInfo newGroup = groupInfoMapper.requestToNewGroup(request);
        newGroup.setDateTime(Instant.now());
        GroupInfo savedGroup = groupInfoRepository.save(newGroup);
        userInGroupService.newGroupModerator(request.getUserId(), savedGroup);
        groupBalanceService.addNewGroupBalance(savedGroup);
    }

    public GroupInfo getGroupById(Integer groupInfoId) {
        Optional<GroupInfo> groupInfo = groupInfoRepository.findById(groupInfoId);
        validationService.isValidGroup(groupInfo, groupInfoId);
        return groupInfo.get();

    }
}
