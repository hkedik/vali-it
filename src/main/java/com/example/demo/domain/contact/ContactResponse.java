package com.example.demo.domain.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactResponse implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String tel;
    private String accountNumber;
}
