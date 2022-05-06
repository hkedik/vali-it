package com.example.demo.domain.group_info;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class GroupInfoResponse {

    private Integer groupId;
    private String groupName;
    private String description;
    @Nullable
    private boolean isModerator;

}
