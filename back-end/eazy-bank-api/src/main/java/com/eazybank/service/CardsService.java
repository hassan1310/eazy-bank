package com.eazybank.service;


import com.eazybank.entity.AccountTransactions;
import com.eazybank.entity.Cards;
import com.eazybank.repository.AccountTransactionsRepository;
import com.eazybank.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsService {

    private final CardsRepository repository;

    public List<Cards> getBalanceDetails(int customerId) {
        return repository.findByCustomerId(customerId);
    }

}
