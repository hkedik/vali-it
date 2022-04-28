package com.example.demo.domain.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select c from Contact c where upper(c.email) = upper(?1)")
    Contact findByEmail(String email);


}