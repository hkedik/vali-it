package com.example.demo.domain.contact;


import com.example.demo.domain.user.NewUserInfoRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;


    public Contact addNewContact(NewUserInfoRequest request) {
        Contact contact = new Contact();
        contact.setFirstName(request.getContactFirstName());
        contact.setLastName(request.getContactLastName());
        contact.setAccountNumber(request.getContactAccountNumber());
        contact.setEmail(request.getContactEmail());
        contact.setTel(request.getContactTel());
        contactRepository.save(contact);
        return contact;
    }
}
