package com.example.demo.domain.expense_picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpencePictureRepository extends JpaRepository<ExpencePicture, Integer> {
    @Query("select e from ExpencePicture e where e.expence.id = ?1")
    List<ExpencePicture> findByExpenceId(Integer id);
}