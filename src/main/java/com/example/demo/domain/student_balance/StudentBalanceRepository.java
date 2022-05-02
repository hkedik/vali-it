package com.example.demo.domain.student_balance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentBalanceRepository extends JpaRepository<StudentBalance, Integer> {
    @Query("select s from StudentBalance s where s.student.id = ?1")
    Optional<StudentBalance> findByStudent_Id(Integer id);
}