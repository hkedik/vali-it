package com.example.demo.service.image;

import lombok.Data;

@Data
public class ImageRequest {
    private Integer id;
    private String title;
    private String description;
    private String data;
}
