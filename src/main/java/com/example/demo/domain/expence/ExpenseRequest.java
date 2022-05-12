package com.example.demo.domain.expence;

import com.example.demo.domain.student.StudentInfoResponse;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ExpenseRequest implements Serializable {

    private Integer groupId;
    private Integer pictureId;
    private String name;
    private String description;
    private BigDecimal amount;
    private List<StudentInfoResponse> students;
}
