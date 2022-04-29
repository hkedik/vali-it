package com.example.demo.domain.group_info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer> {
    @Query("select g from GroupInfo g where upper(g.groupName) = upper(?1)")
    Optional<GroupInfo> findByGroupName(String groupName);

}