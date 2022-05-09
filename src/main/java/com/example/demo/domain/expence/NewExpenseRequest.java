package com.example.demo.domain.expence;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class NewExpenseRequest implements Serializable {
    private Integer groupId;
    private String name;
    private String description;
    private Integer amount;

}
