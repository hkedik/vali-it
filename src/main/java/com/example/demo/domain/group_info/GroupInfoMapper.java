package com.example.demo.domain.group_info;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GroupInfoMapper {


    GroupInfo requestToNewGroup(GroupInfoRequest request);

    GroupInfoRequest groupInfoToGroupInfoDto(GroupInfo groupInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGroupInfoFromGroupInfoDto(GroupInfoRequest groupInfoRequest, @MappingTarget GroupInfo groupInfo);
}
