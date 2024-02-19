package com.eazybank.controller;

import com.eazybank.entity.Account;
import com.eazybank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping("myAccount")
    public List<Account> getAccountDetails(@RequestParam("customerId") int customerId) {
        return service.getCustomerAccount(customerId);
    }
}
