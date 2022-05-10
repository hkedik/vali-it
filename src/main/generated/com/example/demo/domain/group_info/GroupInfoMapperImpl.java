package com.example.demo.domain.group_info;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-09T16:02:42+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class GroupInfoMapperImpl implements GroupInfoMapper {

    @Override
    public GroupInfo requestToNewGroup(GroupInfoRequest request) {
        if ( request == null ) {
            return null;
        }

        GroupInfo groupInfo = new GroupInfo();

        groupInfo.setGroupName( request.getGroupName() );
        groupInfo.setDescription( request.getDescription() );

        return groupInfo;
    }

    @Override
    public GroupInfoRequest groupInfoToGroupInfoDto(GroupInfo groupInfo) {
        if ( groupInfo == null ) {
            return null;
        }

        GroupInfoRequest groupInfoRequest = new GroupInfoRequest();

        groupInfoRequest.setGroupName( groupInfo.getGroupName() );
        groupInfoRequest.setDescription( groupInfo.getDescription() );

        return groupInfoRequest;
    }

    @Override
    public void updateGroupInfoFromGroupInfoDto(GroupInfoRequest groupInfoRequest, GroupInfo groupInfo) {
        if ( groupInfoRequest == null ) {
            return;
        }

        if ( groupInfoRequest.getGroupName() != null ) {
            groupInfo.setGroupName( groupInfoRequest.getGroupName() );
        }
        if ( groupInfoRequest.getDescription() != null ) {
            groupInfo.setDescription( groupInfoRequest.getDescription() );
        }
    }
}
