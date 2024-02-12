package com.eazybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactUsController {

    @GetMapping("contact")
    public String contactUs(){
        return "contact us";
    }
}
