package com.example.demo.domain.expence;

import com.example.demo.domain.group_balance.GroupBalance;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-05T16:07:46+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ExpenceMapperImpl implements ExpenceMapper {

    @Override
    public Expence expenceRequestToExpence(ExpenseRequest expenseRequest) {
        if ( expenseRequest == null ) {
            return null;
        }

        Expence expence = new Expence();

        expence.setName( expenseRequest.getName() );
        expence.setDescription( expenseRequest.getDescription() );
        if ( expenseRequest.getAmount() != null ) {
            expence.setAmount( expenseRequest.getAmount().intValue() );
        }
        expence.setGroupBalance( expenseRequestToGroupBalance( expenseRequest ) );

        return expence;
    }

    protected GroupBalance expenseRequestToGroupBalance(ExpenseRequest expenseRequest) {
        if ( expenseRequest == null ) {
            return null;
        }

        GroupBalance groupBalance = new GroupBalance();

        return groupBalance;
    }
}
