package com.example.demo.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.groupInfo.id = ?1")
    List<Student> findStudentsByGroupId(Integer groupId);

    @Query("select s from Student s where s.groupInfo.id = ?1 and s.active = ?2")
    List<Student> findUnregisteredStudents(Integer id, Boolean active);



}