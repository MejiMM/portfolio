package com.portfolio.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordEncoderGenerator {
    
    public static void main(String[] args) {
        
        PasswordEncoder passEncoder = new BCryptPasswordEncoder();
    }
}
