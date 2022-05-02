package com.example.demo.domain.expence;

import com.example.demo.domain.contact.Contact;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class ExpenceService {

    @Resource
    private ExpenceRepository expenceRepository;

    @Resource
    private ExpenceMapper expenceMapper;

    public void addNewExpence(ExpenceRequest request) {
        Expence expence = expenceMapper.requestToExpence(request);
        expenceRepository.save(expence);
    }

}