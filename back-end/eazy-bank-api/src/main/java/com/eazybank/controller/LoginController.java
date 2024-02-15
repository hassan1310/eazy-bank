package com.eazybank.controller;

import com.eazybank.dto.request.SignUp;
import com.eazybank.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUp request) {
        try{
            var client = loginService.signUp(request);
            return ResponseEntity.status(HttpStatus.OK).body("user '%s' created successfully".formatted(request.getName()));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("create user '%s' failed because of '%s' "
                    .formatted(request.getName(),e.getMessage()));
        }


    }
}
