package com.eazybank.controller;

import com.eazybank.entity.Contact;
import com.eazybank.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ContactController {

  private final ContactService service;

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        return service.saveContactInquiryDetails(contact);
    }


}
