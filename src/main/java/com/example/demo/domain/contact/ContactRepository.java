package com.example.demo.domain.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ContactRepository extends JpaRepository<Contact, Integer> {


}