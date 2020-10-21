package com.luv2code.springdemo.restapp.passwordReset;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<PasswordResetModel,Integer> {
    PasswordResetModel findByToken(String token);

}
