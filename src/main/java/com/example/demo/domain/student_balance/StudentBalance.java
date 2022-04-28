package com.example.demo.domain.student_balance;

import com.example.demo.domain.group_balance.GroupBalance;
import com.example.demo.domain.student.Student;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "student_balance")
public class StudentBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_balance_id", nullable = false)
    private GroupBalance groupBalance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "balance", nullable = false, precision = 8, scale = 2)
    private BigDecimal balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GroupBalance getGroupBalance() {
        return groupBalance;
    }

    public void setGroupBalance(GroupBalance groupBalance) {
        this.groupBalance = groupBalance;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}