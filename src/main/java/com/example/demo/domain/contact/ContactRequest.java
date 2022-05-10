package com.example.demo.domain.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactRequest implements Serializable {
    private Integer userId;
    private String contactFirstName;
    private String contactLastName;
    private String contactEmail;
    private String contactTel;
    private String contactAccountNumber;
}
