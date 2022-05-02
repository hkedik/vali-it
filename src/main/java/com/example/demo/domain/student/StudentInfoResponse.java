package com.example.demo.domain.student;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class StudentInfoResponse implements Serializable {
    private Integer studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Boolean active;
}
