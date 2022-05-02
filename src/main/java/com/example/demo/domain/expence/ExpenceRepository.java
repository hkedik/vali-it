package com.example.demo.domain.expence;

import com.example.demo.domain.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenceRepository extends JpaRepository<Expence, Integer> {
    @Query("select c from Expence c where upper(c.groupName) = upper(?1)")
    List <Expence>findByGroupName(String groupName);
}