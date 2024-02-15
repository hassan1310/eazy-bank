package com.eazybank.security;

import com.eazybank.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@AllArgsConstructor
public class EazyBankUserDetails implements UserDetails {

    private final Client client;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(client.getRole()));
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return client.getEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return client.getEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return client.getEnabled();
    }

    @Override
    public boolean isEnabled() {
        return client.getEnabled();
    }
}