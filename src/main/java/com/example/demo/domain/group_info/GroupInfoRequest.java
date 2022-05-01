package com.example.demo.domain.group_info;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupInfoRequest implements Serializable {
    private final Integer userId;
    private final String groupName;
    private final String description;
}
