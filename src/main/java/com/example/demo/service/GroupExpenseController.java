package com.example.demo.service;

import com.example.demo.domain.contact.ContactDto;
import com.example.demo.domain.contact.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/expense")
public class GroupExpenseController {

    @Resource
    private GroupExpenseService groupExpenseService;

    @Resource
    private ContactService contactService;

    @PostMapping("/new-user")
    @Operation(summary = "Add new user")
    public void addNewUser(@RequestParam String username, @RequestParam String password) {
        groupExpenseService.addNewUser(username, password);
    }

    @PostMapping("/new-contact-info")
    @Operation(summary = "Add contact info")
    public void addNewContactInfo(@RequestBody ContactDto contactDto) {
        groupExpenseService.addNewContactInfo(contactDto);
    }
}
