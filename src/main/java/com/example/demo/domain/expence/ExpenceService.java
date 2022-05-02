package com.example.demo.domain.expence;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class ExpenceService {

    @Resource
    private ExpenceRepository expenceRepository;

    public void addNewExpence(ExpenceRequest request) {
        expenceRepository.save(request);

    }
}

