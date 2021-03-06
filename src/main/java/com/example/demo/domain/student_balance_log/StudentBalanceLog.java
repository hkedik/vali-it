package com.example.demo.domain.student_balance_log;

import com.example.demo.domain.expence.Expence;
import com.example.demo.domain.student_balance.StudentBalance;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "student_balance_log")
public class StudentBalanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expence_id")
    private Expence expence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_balance_id", nullable = false)
    private StudentBalance studentBalance;

    @Column(name = "date_time", nullable = false)
    private Instant dateTime;

    @Column(name = "amount", nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "type", nullable = false, length = 1)
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Expence getExpence() {
        return expence;
    }

    public void setExpence(Expence expence) {
        this.expence = expence;
    }

    public StudentBalance getStudentBalance() {
        return studentBalance;
    }

    public void setStudentBalance(StudentBalance studentBalance) {
        this.studentBalance = studentBalance;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}