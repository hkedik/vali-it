package com.example.demo.service.image;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/receipt-picture")
public class ImageController {

    @Resource
    private ImageService imageService;

    @PostMapping("/in")
    public Integer addReceiptPicture(@RequestBody ImageRequest request) {
       return imageService.addReceiptPicture(request);
    }

    @GetMapping("/all")
    public List<ImageResponse> getAllPictures(@RequestParam Integer expenseId) {
        return imageService.getAllPictures(expenseId);
    }

}


