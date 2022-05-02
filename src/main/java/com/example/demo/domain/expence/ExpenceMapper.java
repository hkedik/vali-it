package com.example.demo.domain.expence;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExpenceMapper {
    @Mapping(source = "groupBalanceId", target = "groupBalance.id")
    @Mapping(source = "groupBalanceBalance", target = "groupBalance.balance")
    Expence requestToExpence(ExpenceRequest expenceRequest);

    @InheritInverseConfiguration(name = "expenceRequestToExpence")
    ExpenceRequest expenceToRequest(Expence expence);

    @InheritConfiguration(name = "expenceRequestToExpence")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExpenceFromRequest(ExpenceRequest expenceRequest, @MappingTarget Expence expence);
}
