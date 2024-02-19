package com.eazybank.service;

import com.eazybank.entity.Account;
import com.eazybank.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountsRepository repository;

    public List<Account> getCustomerAccount(int customerId) {
        return repository.findByCustomerId(customerId);
    }
}
