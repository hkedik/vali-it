package com.example.demo.domain.student;

import com.example.demo.domain.group_info.GroupInfo;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_info_id", nullable = false)
    private GroupInfo groupInfo;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "active", nullable = false)
    private Boolean active = false;


}