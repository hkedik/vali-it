package com.example.demo.domain.group_balance;

import com.example.demo.domain.group_info.GroupInfo;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-05T16:37:32+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class GroupBalanceMapperImpl implements GroupBalanceMapper {

    @Override
    public GroupBalance groupBalanceResponseToGroupBalance(GroupBalanceResponse groupBalanceResponse) {
        if ( groupBalanceResponse == null ) {
            return null;
        }

        GroupBalance groupBalance = new GroupBalance();

        groupBalance.setGroupInfo( groupBalanceResponseToGroupInfo( groupBalanceResponse ) );
        groupBalance.setId( groupBalanceResponse.getId() );
        groupBalance.setBalance( groupBalanceResponse.getBalance() );

        return groupBalance;
    }

    @Override
    public GroupBalanceResponse groupBalanceToGroupBalanceResponse(GroupBalance groupBalance) {
        if ( groupBalance == null ) {
            return null;
        }

        Integer groupInfoId = null;
        Integer id = null;
        BigDecimal balance = null;

        groupInfoId = groupBalanceGroupInfoId( groupBalance );
        id = groupBalance.getId();
        balance = groupBalance.getBalance();

        GroupBalanceResponse groupBalanceResponse = new GroupBalanceResponse( id, balance, groupInfoId );

        return groupBalanceResponse;
    }

    @Override
    public void updateGroupBalanceFromGroupBalanceResponse(GroupBalanceResponse groupBalanceResponse, GroupBalance groupBalance) {
        if ( groupBalanceResponse == null ) {
            return;
        }

        if ( groupBalance.getGroupInfo() == null ) {
            groupBalance.setGroupInfo( new GroupInfo() );
        }
        groupBalanceResponseToGroupInfo1( groupBalanceResponse, groupBalance.getGroupInfo() );
        if ( groupBalanceResponse.getId() != null ) {
            groupBalance.setId( groupBalanceResponse.getId() );
        }
        if ( groupBalanceResponse.getBalance() != null ) {
            groupBalance.setBalance( groupBalanceResponse.getBalance() );
        }
    }

    protected GroupInfo groupBalanceResponseToGroupInfo(GroupBalanceResponse groupBalanceResponse) {
        if ( groupBalanceResponse == null ) {
            return null;
        }

        GroupInfo groupInfo = new GroupInfo();

        groupInfo.setId( groupBalanceResponse.getGroupInfoId() );

        return groupInfo;
    }

    private Integer groupBalanceGroupInfoId(GroupBalance groupBalance) {
        if ( groupBalance == null ) {
            return null;
        }
        GroupInfo groupInfo = groupBalance.getGroupInfo();
        if ( groupInfo == null ) {
            return null;
        }
        Integer id = groupInfo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void groupBalanceResponseToGroupInfo1(GroupBalanceResponse groupBalanceResponse, GroupInfo mappingTarget) {
        if ( groupBalanceResponse == null ) {
            return;
        }

        if ( groupBalanceResponse.getGroupInfoId() != null ) {
            mappingTarget.setId( groupBalanceResponse.getGroupInfoId() );
        }
    }
}
