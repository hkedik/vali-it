package com.example.demo.domain.picture;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReceiptPictureMapper {
    ReceiptPicture receiptPictureDtoToReceiptPicture(ReceiptPictureDto receiptPictureDto);

    ReceiptPictureDto receiptPictureToReceiptPictureDto(ReceiptPicture receiptPicture);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateReceiptPictureFromReceiptPictureDto(ReceiptPictureDto receiptPictureDto, @MappingTarget ReceiptPicture receiptPicture);
}
