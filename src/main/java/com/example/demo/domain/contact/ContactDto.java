package com.example.demo.domain.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String tel;
    private final String accountNumber;
}
