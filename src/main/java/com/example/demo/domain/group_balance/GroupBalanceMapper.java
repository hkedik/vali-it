package com.example.demo.domain.group_balance;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GroupBalanceMapper {
    @Mapping(source = "groupInfoId", target = "groupInfo.id")
    GroupBalance groupBalanceResponseToGroupBalance(GroupBalanceResponse groupBalanceResponse);

    @Mapping(source = "groupInfo.id", target = "groupInfoId")
    GroupBalanceResponse groupBalanceToGroupBalanceResponse(GroupBalance groupBalance);

    @Mapping(source = "groupInfoId", target = "groupInfo.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGroupBalanceFromGroupBalanceResponse(GroupBalanceResponse groupBalanceResponse, @MappingTarget GroupBalance groupBalance);
}
