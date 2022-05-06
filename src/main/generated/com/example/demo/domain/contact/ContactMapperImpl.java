package com.example.demo.domain.contact;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-06T15:00:01+0300",
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

        String firstName = null;
        String lastName = null;
        String email = null;
        String tel = null;
        String accountNumber = null;

        firstName = contact.getFirstName();
        lastName = contact.getLastName();
        email = contact.getEmail();
        tel = contact.getTel();
        accountNumber = contact.getAccountNumber();

        ContactResponse contactResponse = new ContactResponse( firstName, lastName, email, tel, accountNumber );

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
    }
}
