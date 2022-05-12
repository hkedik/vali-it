package com.example.demo.domain.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Query("select e from Expense e where e.groupBalance.groupInfo.id = ?1")
    List<Expense> findByGroupId(Integer id);

}