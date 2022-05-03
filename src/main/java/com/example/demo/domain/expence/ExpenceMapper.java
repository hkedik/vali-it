package com.example.demo.domain.expence;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExpenceMapper {


    @Mapping( target = "groupBalance.id", ignore = true)
    Expence expenceRequestToExpence(ExpenseRequest expenseRequest);

//    @Mapping(source = "groupBalance.id", target = "groupBalanceId")
//    ExpenseRequest expenceToExpenceRequest(Expence expence);

//    @Mapping(source = "groupBalanceId", target = "groupBalance.id")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateExpenceFromExpenceRequest(ExpenseRequest expenseRequest, @MappingTarget Expence expence);
}
