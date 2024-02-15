package com.eazybank.security;

import com.eazybank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class EazyBankAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var userName = authentication.getName();
        var password = authentication.getCredentials().toString();

        var client = clientRepository.findByEmail(userName).orElse(null);

        if (client == null) {
            throw new UsernameNotFoundException("user '%' not found ".formatted(userName));
        }

        if (passwordEncoder.matches(password,client.getPassword())) {
            return new UsernamePasswordAuthenticationToken(userName, password,
                    Arrays.asList(new SimpleGrantedAuthority(client.getRole())));
        } else {
            throw new BadCredentialsException(" invalid password for user '%'".formatted(userName));
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
