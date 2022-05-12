package com.example.demo.domain.expense;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExpenseMapper {


    @Mapping( target = "groupBalance.id", ignore = true)
    Expense expenceRequestToExpence(ExpenseRequest expenseRequest);

//    @Mapping(source = "groupBalance.id", target = "groupBalanceId")
//    ExpenseRequest expenceToExpenceRequest(Expense expence);

//    @Mapping(source = "groupBalanceId", target = "groupBalance.id")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateExpenceFromExpenceRequest(ExpenseRequest expenseRequest, @MappingTarget Expense expence);
}
