package com.eazybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/account", "/balance", "/cards", "loans").authenticated()
                        .requestMatchers("notices", "/contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults()).build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        var admin = User.withUsername("admin").password("admin").authorities("admin").build();
        var user = User.withUsername("user").password("user").authorities("read").build();

        userDetailsService.createUser(admin);
        userDetailsService.createUser(user);

        return userDetailsService;
    }

    @Bean

    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
