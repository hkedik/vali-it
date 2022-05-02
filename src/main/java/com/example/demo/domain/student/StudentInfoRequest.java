package com.example.demo.domain.student;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class StudentInfoRequest implements Serializable {
    private final Integer groupInfoId;
    private final Integer parentUserId;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
}
