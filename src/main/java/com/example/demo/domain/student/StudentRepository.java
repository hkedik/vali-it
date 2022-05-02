package com.example.demo.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.groupInfo.id = ?1")
    List<Student> findByGroupInfo_Id(Integer id);

    @Query("select s from Student s where s.groupInfo.id = ?1 and s.active = false")
    List<Student> findRegisteredStudents(Integer id);

}

