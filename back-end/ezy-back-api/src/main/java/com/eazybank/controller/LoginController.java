package com.eazybank.controller;

import com.eazybank.dto.request.SignUp;
import com.eazybank.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("signup")
    public String signUp(@RequestBody @Valid SignUp request) {
        var client=loginService.signUp(request);
        return client.getName();
    }
}
