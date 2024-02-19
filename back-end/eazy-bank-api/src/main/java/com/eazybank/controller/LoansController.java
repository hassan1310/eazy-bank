package com.eazybank.controller;


import com.eazybank.entity.Loans;
import com.eazybank.service.LoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoansService service;

    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam("customerId") int customerId) {
        return service.getLoanDetails(customerId);
    }

}
