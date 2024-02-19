package com.eazybank.security;

import com.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
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
    private final CustomerRepository customerRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        var userName = authentication.getName();
        var password = authentication.getCredentials().toString();

        var client = customerRepository.findByEmail(userName).orElse(null);

        if (client == null) {
            throw new UsernameNotFoundException("user '%s' not found ".formatted(userName));
        }

        if (passwordEncoder.matches(password,client.getPwd())) {
            return new UsernamePasswordAuthenticationToken(userName, password,
                    Arrays.asList(new SimpleGrantedAuthority(client.getRole())));
        } else {
            throw new BadCredentialsException("invalid password for user '%s' ".formatted(userName));
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
