package com.example.demo.domain.group_balance;

import com.example.demo.domain.group_info.GroupInfo;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class GroupBalanceService {

    @Resource
    private GroupBalanceRepository groupBalanceRepository;
  //  private GroupInfo groupInfo;

    @Resource
    private ValidationService validationService;

    public void addNewGroupBalance(GroupInfo groupInfo) {
      //  this.groupInfo = groupInfo;
        GroupBalance groupBalance = new GroupBalance();
        groupBalance.setGroupInfo(groupInfo);
        groupBalance.setBalance(BigDecimal.valueOf(0.00));
        groupBalanceRepository.save(groupBalance);
    }

    public GroupBalance findGroupBalanceByGroupId(Integer groupId) {
        Optional<GroupBalance> byGroupInfo_id = groupBalanceRepository.findByGroupInfo_Id(groupId);
        validationService.isValidGroupBalance(byGroupInfo_id);
        return byGroupInfo_id.get();

    }

    public void addMoneyToGroupBalance(Integer groupBalanceId, BigDecimal amount) {
        Optional<GroupBalance> balance = groupBalanceRepository.findById(groupBalanceId);
        validationService.isValidGroupBalance(balance);
        GroupBalance groupBalance = balance.get();
        BigDecimal groupMoney = groupBalance.getBalance();
        groupBalance.setBalance(groupMoney.add(amount));
        groupBalanceRepository.save(groupBalance);
    }
}
