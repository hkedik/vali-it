package com.example.demo.domain.user_student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserStudentRepository extends JpaRepository<UserStudent, Integer> {
    @Query("select u from UserStudent u where u.student.id = ?1")
    Optional<UserStudent> findByStudentId(Integer id);


}