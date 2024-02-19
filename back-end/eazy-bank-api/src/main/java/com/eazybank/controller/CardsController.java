package com.eazybank.controller;


import com.eazybank.entity.Cards;
import com.eazybank.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsService service;

    @GetMapping("myCards")
    public List<Cards> getCardDetails(@RequestParam("customerId") int customerId) {
        return service.getBalanceDetails(customerId);
    }

}
