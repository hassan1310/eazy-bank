package com.eazybank.security;


import com.eazybank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EazyBankUserDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;

    // not used because I used the filter
    @Override
    public UserDetails loadUserByUsername(String username) {
        return clientRepository.findByEmail(username).map(EazyBankUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user '%s' not found".formatted(username)));
    }
}
