package com.example.demo.domain.user_student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserStudentRepository extends JpaRepository<UserStudent, Integer> {

    @Query("select u from UserStudent u where u.user.id = ?1")
    List<UserStudent> findByUser_Id(Integer id);


    @Query("select u from UserStudent u where u.student.id = ?1")
    Optional<UserStudent> findByStudentId(Integer id);


}