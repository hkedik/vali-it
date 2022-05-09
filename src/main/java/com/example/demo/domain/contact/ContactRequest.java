package com.example.demo.domain.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactRequest implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String tel;
    private String accountNumber;
}
