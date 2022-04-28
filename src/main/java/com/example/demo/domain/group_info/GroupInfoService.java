package com.example.demo.domain.group_info;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class GroupInfoService {

    @Resource
    private GroupInfoMapper groupInfoMapper;

    @Resource
    private GroupInfoRepository groupInfoRepository;


    public void addNewGroup(GroupInfoRequest groupInfoRequest) {
        GroupInfo groupInfo = groupInfoMapper.requestToGroupInfo(groupInfoRequest);
        groupInfo.setDateTime(Instant.now());
        groupInfoRepository.save(groupInfo);


    }
}
