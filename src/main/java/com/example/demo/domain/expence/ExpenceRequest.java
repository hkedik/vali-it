package com.example.demo.domain.expence;


import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class ExpenceRequest implements Serializable {

    private final Integer expenceId;
    private final String expenceTitle;
    private final String expenceDescription;
    private final Integer expenceAmount;
    private final Instant dateTime;

}
