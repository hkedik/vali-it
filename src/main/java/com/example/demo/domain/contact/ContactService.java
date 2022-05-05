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


//        Optional<UserStudent> userStudent = userStudentRepository.findByStudentId(studentId);
//        validationService.isValidUserStudentRelationship(userStudent, studentId);
//        UserStudent userStudent1 = userStudent.get();
//        Optional<User> user = userRepository.findById(userStudent1.getId());
//        validationService.isValidUser(userStudent1.getUser().getId(), user);
//        Optional<Contact> contact = contactRepository.findById(user.get().getContact().getId());
//        validationService.isValidContact(contact);
//        return contactMapper.contactToContactResponse(contact.get());
    }

    public void updateParentContactInfo(ContactRequest request) {
        User user = userRepository.getById(request.getUserId());
        Optional<Contact> contact = contactRepository.findById(user.getContact().getId());
        validationService.isValidContact(contact);
        Contact updatedContact = contact.get();
        contactMapper.updateContactFromContactRequest(request, updatedContact);

        contactRepository.save(updatedContact);

    }
}
