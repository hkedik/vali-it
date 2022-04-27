package com.example.demo.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Integer id;
    private final Integer contactId;
    private final String contactFirstName;
    private final String contactLastName;
    private final String contactEmail;
    private final String contactTel;
    private final String contactAccountNumber;
    private final String userName;
    private final String password;
}
