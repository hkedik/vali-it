package com.example.demo.domain.contact;


import com.example.demo.domain.user.NewUserInfoRequest;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserRepository;
import com.example.demo.domain.user_student.UserStudent;
import com.example.demo.domain.user_student.UserStudentRepository;
import com.example.demo.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ContactService {

    @Resource
    private ContactRepository contactRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ValidationService validationService;

    @Resource
    private UserStudentRepository userStudentRepository;


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

    public ContactResponse getContactInfoByUserId(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        validationService.isValidUser(userId, user);
        return contactMapper.contactToContactResponse(user.get().getContact());
    }

    public ContactResponse getContactInfoByStudentId(Integer studentId) {
        UserStudent userStudent = userStudentRepository.getById(studentId);
        User user = userRepository.getById(userStudent.getUser().getId());
        Optional<Contact> contact = contactRepository.findById(user.getContact().getId());
        validationService.isValidContact(contact);
        return contactMapper.contactToContactResponse(contact.get());

    }



    public void updateContactInfo(ContactRequest request) {
        User user = userRepository.getById(request.getId());
        Contact contact = contactRepository.getById(user.getContact().getId());
        contactMapper.updateContactFromContactRequest(request, contact);
        contactRepository.save(contact);
    }
}
