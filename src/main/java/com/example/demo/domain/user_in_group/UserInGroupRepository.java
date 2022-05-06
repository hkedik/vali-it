package com.example.demo.domain.user_in_group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInGroupRepository extends JpaRepository<UserInGroup, Integer> {
    List<UserInGroup> findByUserIdList(Integer userId);

    UserInGroup findByUserId(Integer userId);



}