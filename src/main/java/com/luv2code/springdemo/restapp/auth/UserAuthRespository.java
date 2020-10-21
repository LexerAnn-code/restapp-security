package com.luv2code.springdemo.restapp.auth;

import org.springframework.data.repository.CrudRepository;

public interface UserAuthRespository  extends CrudRepository<User,Long> {
    User findByEmail(String email);
    User findByEmailVerificationToken(String token);
}
