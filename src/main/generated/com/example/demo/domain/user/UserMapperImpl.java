package com.example.demo.domain.user;

import com.example.demo.domain.contact.Contact;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-05T16:37:32+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Contact requestToContact(NewUserInfoRequest newUserInfoRequest) {
        if ( newUserInfoRequest == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setFirstName( newUserInfoRequest.getContactFirstName() );
        contact.setLastName( newUserInfoRequest.getContactLastName() );
        contact.setEmail( newUserInfoRequest.getContactEmail() );
        contact.setTel( newUserInfoRequest.getContactTel() );
        contact.setAccountNumber( newUserInfoRequest.getContactAccountNumber() );

        return contact;
    }

    @Override
    public User requestToUser(NewUserInfoRequest newUserInfoRequest) {
        if ( newUserInfoRequest == null ) {
            return null;
        }

        User user = new User();

        user.setUserName( newUserInfoRequest.getUserName() );
        user.setPassword( newUserInfoRequest.getPassword() );

        return user;
    }
}
