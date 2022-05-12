package com.example.demo.domain.picture;

import com.example.demo.domain.expense_picture.ExpencePicture;
import com.example.demo.domain.expense_picture.ExpencePictureRepository;
import com.example.demo.domain.expense_picture.ExpensePictureService;
import com.example.demo.service.image.ImageRequest;
import com.example.demo.service.image.ImageResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class PictureService {


    @Resource
    private ReceiptPictureRepository receiptPictureRepository;


    @Resource
    private ExpencePictureRepository expencePictureRepository;


    public Integer addReceiptPicture(ImageRequest request) {
        byte[] data = request.getData().getBytes(StandardCharsets.UTF_8);
        ReceiptPicture picture = new ReceiptPicture();
        picture.setData(data);
        receiptPictureRepository.save(picture);
        return picture.getId();

    }

    public ReceiptPicture getPicture(Integer pictureId) {
        return receiptPictureRepository.getById(pictureId);
    }

    public List<ImageResponse> getAllPictures(Integer expenseId) {
        List<ExpencePicture> pictureIdsByExpenseId = expencePictureRepository.findByExpenceId(expenseId);
        List<ImageResponse> responses = new ArrayList<>();
        for (ExpencePicture expencePicture : pictureIdsByExpenseId) {
            ReceiptPicture picture = receiptPictureRepository.getById(expencePicture.getReceiptPicture().getId());
            ImageResponse response = new ImageResponse();
            response.setId(picture.getId());
            String dataString = new String(picture.getData(), StandardCharsets.UTF_8);
            response.setData(dataString);
            responses.add(response);
        }

        return responses;
    }
}
