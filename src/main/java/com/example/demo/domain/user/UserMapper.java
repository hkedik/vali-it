package com.example.demo.domain.user;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "contactId", target = "contact.id")
    @Mapping(source = "contactFirstName", target = "contact.firstName")
    @Mapping(source = "contactLastName", target = "contact.lastName")
    @Mapping(source = "contactEmail", target = "contact.email")
    @Mapping(source = "contactTel", target = "contact.tel")
    @Mapping(source = "contactAccountNumber", target = "contact.accountNumber")
    User userDtoToUser(UserDto userDto);

    @InheritInverseConfiguration(name = "userDtoToUser")
    UserDto userToUserDto(User user);

    @InheritConfiguration(name = "userDtoToUser")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDto(UserDto userDto, @MappingTarget User user);
}
