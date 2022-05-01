package com.example.demo.domain.group_balance;

import com.example.demo.domain.group_info.GroupInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class GroupBalanceService {

    @Resource
    private GroupBalanceRepository groupBalanceRepository;
    private GroupInfo groupInfo;

    public void addNewGroupBalance(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
        GroupBalance groupBalance = new GroupBalance();
        groupBalance.setGroupInfo(groupInfo);
        groupBalance.setBalance(BigDecimal.valueOf(0.00));
        groupBalanceRepository.save(groupBalance);
    }
}
