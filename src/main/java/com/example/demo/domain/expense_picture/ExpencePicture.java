package com.example.demo.domain.expense_picture;

import com.example.demo.domain.expence.Expence;
import com.example.demo.domain.picture.ReceiptPicture;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "expence_picture")
public class ExpencePicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "expence_id", nullable = false)
    private Expence expence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receipt_picture_id", nullable = false)
    private ReceiptPicture receiptPicture;

}