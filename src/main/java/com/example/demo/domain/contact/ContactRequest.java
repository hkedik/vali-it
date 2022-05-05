package com.example.demo.domain.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactRequest implements Serializable {
    private final Integer userId;
    private final String contactFirstName;
    private final String contactLastName;
    private final String contactEmail;
    private final String contactTel;
    private final String contactAccountNumber;
}
