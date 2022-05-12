package com.example.demo.domain.expence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenceRepository extends JpaRepository<Expence, Integer> {
    @Query("select e from Expence e where e.groupBalance.groupInfo.id = ?1")
    List<Expence> findByGroupId(Integer id);

    @Query("select e from Expence e where e.name = ?1")
    Expence findByName(String name);




}