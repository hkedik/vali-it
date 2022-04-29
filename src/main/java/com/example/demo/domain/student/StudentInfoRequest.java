package com.example.demo.domain.student;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class StudentInfoRequest implements Serializable {
    private Integer groupInfoId;
    private Integer parentUserId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
