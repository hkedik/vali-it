package com.example.demo.domain.student;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentInfoResponse implements Serializable {
    private Integer studentId;
    private Integer parentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Boolean active;

    public StudentInfoResponse(Integer studentId) {
        this.studentId = studentId;
    }
}
