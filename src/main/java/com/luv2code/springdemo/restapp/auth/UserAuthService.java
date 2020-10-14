package com.luv2code.springdemo.restapp.auth;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAuthService extends UserDetailsService {
   void createUser(User user);
}
