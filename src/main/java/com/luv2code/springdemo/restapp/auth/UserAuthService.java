package com.luv2code.springdemo.restapp.auth;

import com.luv2code.springdemo.restapp.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAuthService extends UserDetailsService {
   void createUser(UserDto userdto);
    boolean verifyEmailToken(String token);
}
