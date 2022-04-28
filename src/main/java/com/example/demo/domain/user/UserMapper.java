package com.example.demo.domain.user;

import com.example.demo.domain.contact.Contact;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
//    @Mapping(source = "contactId", target = "contact.id")
//    @Mapping(source = "contactFirstName", target = "contact.firstName")
//    @Mapping(source = "contactLastName", target = "contact.lastName")
//    @Mapping(source = "contactEmail", target = "contact.email")
//    @Mapping(source = "contactTel", target = "contact.tel")
//    @Mapping(source = "contactAccountNumber", target = "contact.accountNumber")
//    User userDtoToUser(NewUserInfoRequest userDto);

    @Mapping(source = "contactFirstName", target = "firstName")
    @Mapping(source = "contactLastName", target = "lastName")
    @Mapping(source = "contactEmail", target = "email")
    @Mapping(source = "contactTel", target = "tel")
    @Mapping(source = "contactAccountNumber", target = "accountNumber")
    Contact requestToContact(NewUserInfoRequest newUserInfoRequest);

    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "password", target = "password")
    User requestToUser(NewUserInfoRequest newUserInfoRequest);

//    @InheritInverseConfiguration(name = "userDtoToUser")
//    NewUserInfoRequest userToUserDto(User user);
//
//    @InheritConfiguration(name = "userDtoToUser")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateUserFromUserDto(NewUserInfoRequest userDto, @MappingTarget User user);
}
