package com.example.demo.domain.expense;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewExpenseRequest implements Serializable {
    private Integer groupId;
    private String name;
    private String description;
    private Integer amount;

}
