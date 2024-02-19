package com.eazybank.service;


import com.eazybank.entity.Loans;
import com.eazybank.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoansService {

    private final LoansRepository repository;

    public List<Loans> getLoanDetails(int customerId) {
        return repository.findByCustomerIdOrderByStartDtDesc(customerId);
    }

}
