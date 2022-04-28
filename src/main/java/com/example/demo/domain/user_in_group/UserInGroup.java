package com.example.demo.domain.user_in_group;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user_in_group")
public class UserInGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "group_info_id", nullable = false)
    private Integer groupInfoId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "date_activated", nullable = false)
    private LocalDate dateActivated;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @Column(name = "is_moderator", nullable = false)
    private Boolean isModerator = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupInfoId() {
        return groupInfoId;
    }

    public void setGroupInfoId(Integer groupInfoId) {
        this.groupInfoId = groupInfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getDateActivated() {
        return dateActivated;
    }

    public void setDateActivated(LocalDate dateActivated) {
        this.dateActivated = dateActivated;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsModerator() {
        return isModerator;
    }

    public void setIsModerator(Boolean isModerator) {
        this.isModerator = isModerator;
    }

}