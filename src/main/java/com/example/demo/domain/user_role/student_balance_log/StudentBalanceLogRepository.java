package com.example.demo.domain.user_role.student_balance_log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentBalanceLogRepository extends JpaRepository<StudentBalanceLog, Integer> {
    @Query("select s from StudentBalanceLog s where s.studentBalance.student.id = ?1")
    List<StudentBalanceLog> findByStudentId(Integer id);


}