package com.example.demo.domain.contact;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T10:53:22+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact contactResponseToContact(ContactResponse contactResponse) {
        if ( contactResponse == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setFirstName( contactResponse.getFirstName() );
        contact.setLastName( contactResponse.getLastName() );
        contact.setEmail( contactResponse.getEmail() );
        contact.setTel( contactResponse.getTel() );
        contact.setAccountNumber( contactResponse.getAccountNumber() );

        return contact;
    }

    @Override
    public ContactResponse contactToContactResponse(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        ContactResponse contactResponse = new ContactResponse();

        contactResponse.setFirstName( contact.getFirstName() );
        contactResponse.setLastName( contact.getLastName() );
        contactResponse.setEmail( contact.getEmail() );
        contactResponse.setTel( contact.getTel() );
        contactResponse.setAccountNumber( contact.getAccountNumber() );

        return contactResponse;
    }

    @Override
    public void updateContactFromContactResponse(ContactResponse contactResponse, Contact contact) {
        if ( contactResponse == null ) {
            return;
        }

        if ( contactResponse.getFirstName() != null ) {
            contact.setFirstName( contactResponse.getFirstName() );
        }
        if ( contactResponse.getLastName() != null ) {
            contact.setLastName( contactResponse.getLastName() );
        }
        if ( contactResponse.getEmail() != null ) {
            contact.setEmail( contactResponse.getEmail() );
        }
        if ( contactResponse.getTel() != null ) {
            contact.setTel( contactResponse.getTel() );
        }
        if ( contactResponse.getAccountNumber() != null ) {
            contact.setAccountNumber( contactResponse.getAccountNumber() );
        }
    }

    @Override
    public void updateContactFromContactRequest(ContactRequest contactRequest, Contact contact) {
        if ( contactRequest == null ) {
            return;
        }

        if ( contactRequest.getFirstName() != null ) {
            contact.setFirstName( contactRequest.getFirstName() );
        }
        if ( contactRequest.getLastName() != null ) {
            contact.setLastName( contactRequest.getLastName() );
        }
        if ( contactRequest.getEmail() != null ) {
            contact.setEmail( contactRequest.getEmail() );
        }
        if ( contactRequest.getTel() != null ) {
            contact.setTel( contactRequest.getTel() );
        }
        if ( contactRequest.getAccountNumber() != null ) {
            contact.setAccountNumber( contactRequest.getAccountNumber() );
        }
    }
}
