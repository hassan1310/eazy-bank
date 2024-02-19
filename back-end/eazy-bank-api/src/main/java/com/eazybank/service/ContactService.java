package com.eazybank.service;

import com.eazybank.entity.Contact;
import com.eazybank.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact saveContactInquiryDetails(Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDate(LocalDate.now());
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
