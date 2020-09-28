package com.luv2code.springdemo.restapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncrypt {
    @Bean
public PasswordEncoder passwordEncoders(){
    return new BCryptPasswordEncoder(10);
}
}
