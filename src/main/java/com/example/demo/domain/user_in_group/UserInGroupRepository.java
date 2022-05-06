package com.example.demo.domain.user_in_group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserInGroupRepository extends JpaRepository<UserInGroup, Integer> {
    List<UserInGroup> findByUserId(Integer userId);

    @Query("select u from UserInGroup u where u.userId = ?1")
    UserInGroup findUserConnectionByUserId(Integer userId);



}