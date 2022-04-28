package com.example.demo.domain.student;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class NewStudentRequest implements Serializable {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Boolean active;
}
