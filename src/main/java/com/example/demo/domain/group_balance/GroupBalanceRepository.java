package com.example.demo.domain.group_balance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GroupBalanceRepository extends JpaRepository<GroupBalance, Integer> {
    @Query("select g from GroupBalance g where g.groupInfo.id = ?1")
    Optional<GroupBalance> findByGroupInfo_Id(Integer id);


}