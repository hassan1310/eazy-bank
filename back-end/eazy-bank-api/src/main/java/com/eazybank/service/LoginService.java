package com.eazybank.service;


import com.eazybank.dto.request.SignUp;
import com.eazybank.entity.Customer;
import com.eazybank.repository.CardsRepository;
import com.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUp request) throws Exception {

        var customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setRole(request.getRole());
        customer.setPwd(passwordEncoder.encode(request.getPassword()));
        customer.setMobileNumber(request.getMobile());
        customer.setCreateDate(LocalDate.now().toString());

        customerRepository.save(customer);
    }
}
