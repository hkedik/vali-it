package com.example.demo.domain.expense;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExpenseMapper {


    @Mapping( target = "groupBalance.id", ignore = true)
    Expense expenseRequestToExpense(com.example.demo.domain.expense.ExpenseRequest expenseRequest);

//    @Mapping(source = "groupBalance.id", target = "groupBalanceId")
//    ExpenseRequest expenseToexpenseRequest(expense expense);

//    @Mapping(source = "groupBalanceId", target = "groupBalance.id")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateexpenseFromexpenseRequest(ExpenseRequest expenseRequest, @MappingTarget expense expense);
}
