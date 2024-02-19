package com.eazybank.controller;


import com.eazybank.entity.AccountTransactions;
import com.eazybank.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService service;

    @GetMapping("myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam("customerId") int customerId) {
        return service.getBalanceDetails(customerId);
    }
}
