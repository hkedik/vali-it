package com.example.demo.domain.group_info;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupInfoRequest implements Serializable {
    private Integer userId;
    private String groupName;
    private String description;
}
