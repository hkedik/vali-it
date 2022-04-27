package com.example.demo.domain.expence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenceRepository extends JpaRepository<Expence, Integer> {
}