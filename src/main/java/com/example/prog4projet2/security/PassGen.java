package com.example.prog4projet2.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PassGen {
    private String Pass(String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode(password);
    }
}
