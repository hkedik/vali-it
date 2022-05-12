package com.example.demo.service.image;

import com.example.demo.domain.picture.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImageService {

    @Resource
    private PictureService pictureService;

    public Integer addReceiptPicture(ImageRequest request) {
       return pictureService.addReceiptPicture(request);
    }

    public List<ImageResponse> getAllPictures(Integer expenseId) {
        return pictureService.getAllPictures(expenseId);
    }
}
