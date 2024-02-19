package com.eazybank.service;


import com.eazybank.dto.request.SignUp;
import com.eazybank.entity.Account;
import com.eazybank.entity.AccountTransactions;
import com.eazybank.entity.Customer;
import com.eazybank.repository.AccountTransactionsRepository;
import com.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final AccountTransactionsRepository repository;

    public List<AccountTransactions> getBalanceDetails(int customerId) {
        return repository.findByCustomerIdOrderByTransactionDtDesc(customerId);
    }

}
