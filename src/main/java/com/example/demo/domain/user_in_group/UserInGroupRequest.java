package com.example.demo.domain.user_in_group;

import com.example.demo.domain.group_info.GroupInfo;
import lombok.Data;

@Data
public class UserInGroupRequest {
    private Integer userId;
    private GroupInfo groupInfo;
}
