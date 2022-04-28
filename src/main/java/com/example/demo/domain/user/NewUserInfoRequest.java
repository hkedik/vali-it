package com.example.demo.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewUserInfoRequest implements Serializable {

    private final String contactFirstName;
    private final String contactLastName;
    private final String contactEmail;
    private final String contactTel;
    private final String contactAccountNumber;
    private final String userName;
    private final String password;
}
