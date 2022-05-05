package com.example.demo.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewUserInfoRequest implements Serializable {

    private String contactFirstName;
    private String contactLastName;
    private String contactEmail;
    private String contactTel;
    private String contactAccountNumber;
    private String userName;
    private String password;
}
