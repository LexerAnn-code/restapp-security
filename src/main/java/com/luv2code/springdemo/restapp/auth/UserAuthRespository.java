package com.luv2code.springdemo.restapp.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserAuthRespository  extends CrudRepository<UserAuth,Long> {
    UserAuth findUserByEmail(String email);
}
