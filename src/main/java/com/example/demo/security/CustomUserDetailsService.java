package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public CustomUserDetailsService() {}

    @Override
    public UserDetails loadUserByUsername(String username) {
        return new org.springframework.security.core.userdetails.User(
                username,
                "password",
                Collections.emptyList()
        );
    }
}
