package com.eazybank.service;


import com.eazybank.dto.request.SignUp;
import com.eazybank.entity.Client;
import com.eazybank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final ClientRepository clientRepository;

    public Client signUp(SignUp request) {

        var client = new Client();
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setRole(request.getRole());
        client.setPassword(request.getPassword());

        return clientRepository.save(client);
    }
}
