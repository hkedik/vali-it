package com.example.demo.domain.expense;

import com.example.demo.domain.group_balance.GroupBalance;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T10:53:22+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ExpenseMapperImpl implements ExpenseMapper {

    @Override
    public Expense expenceRequestToExpence(ExpenseRequest expenseRequest) {
        if ( expenseRequest == null ) {
            return null;
        }

        Expense expense = new Expense();

        expense.setName( expenseRequest.getName() );
        expense.setDescription( expenseRequest.getDescription() );
        expense.setAmount( expenseRequest.getAmount() );
        expense.setGroupBalance( expenseRequestToGroupBalance( expenseRequest ) );

        return expense;
    }

    protected GroupBalance expenseRequestToGroupBalance(ExpenseRequest expenseRequest) {
        if ( expenseRequest == null ) {
            return null;
        }

        GroupBalance groupBalance = new GroupBalance();

        return groupBalance;
    }
}
