package com.eazybank.service;

import com.eazybank.entity.Contact;
import com.eazybank.entity.Customer;
import com.eazybank.repository.ContactRepository;
import com.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Customer getCustomerByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
