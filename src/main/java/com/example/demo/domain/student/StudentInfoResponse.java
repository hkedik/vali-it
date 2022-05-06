package com.example.demo.domain.student;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class StudentInfoResponse implements Serializable {

    private Integer studentId;
    private String firstName;
    private String lastName;
    private BigDecimal groupBalanceAmount;
    private BigDecimal studentBalanceAmount;
    private Boolean active;
    private Boolean selected = false;


}
