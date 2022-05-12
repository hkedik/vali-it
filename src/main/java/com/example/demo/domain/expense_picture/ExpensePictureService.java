package com.example.demo.domain.expense_picture;


import com.example.demo.domain.expence.Expence;
import com.example.demo.domain.expence.ExpenceService;
import com.example.demo.domain.expence.ExpenseRequest;
import com.example.demo.domain.picture.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ExpensePictureService {

    @Resource
    private ExpencePictureRepository expencePictureRepository;

    @Resource
    private PictureService pictureService;



    public void saveReceiptPicture(ExpenseRequest request, Expence expence) {
        ExpencePicture expencePicture = new ExpencePicture();
        expencePicture.setReceiptPicture(pictureService.getPicture(request.getPictureId()));
        expencePicture.setExpence(expence);
        expencePictureRepository.save(expencePicture);
    }

}
