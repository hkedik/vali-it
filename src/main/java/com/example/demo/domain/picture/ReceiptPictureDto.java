package com.example.demo.domain.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReceiptPictureDto implements Serializable {
    private final Integer id;
    private final byte[] data;
}
