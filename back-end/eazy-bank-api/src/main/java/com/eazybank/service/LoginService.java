package com.eazybank.service;


import com.eazybank.dto.request.SignUp;
import com.eazybank.entity.Client;
import com.eazybank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public Client signUp(SignUp request) throws Exception{

        var client = new Client();
        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setRole(request.getRole());
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        client.setEnabled(request.getEnabled());

        return clientRepository.save(client);
    }
}
