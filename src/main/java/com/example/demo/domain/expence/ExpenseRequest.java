package com.example.demo.domain.expence;

import com.example.demo.domain.student.StudentInfoResponse;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ExpenseRequest implements Serializable {

    private final Integer groupId;
    private final String name;
    private final String description;
    private final BigDecimal amount;
    private final List<StudentInfoResponse> students;
}
