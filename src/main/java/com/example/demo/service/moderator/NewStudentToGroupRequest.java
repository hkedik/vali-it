package com.example.demo.service.moderator;

import lombok.Data;

@Data
public class NewStudentToGroupRequest {
    private Integer userId;
    private Integer moderatorGroupInfoId;
    private Integer parentId;
    private Integer studentId;
}
