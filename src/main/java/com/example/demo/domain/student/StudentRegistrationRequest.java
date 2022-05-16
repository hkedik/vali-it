package com.example.demo.domain.student;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class StudentRegistrationRequest implements Serializable {

    private Integer studentId;
    private Boolean active;
    private Boolean selected = false;


}
