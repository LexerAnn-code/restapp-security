package com.luv2code.springdemo.restapp.auth;

import com.luv2code.springdemo.restapp.ErrorHandling.EmployeeErrorHandling;
import com.luv2code.springdemo.restapp.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAuthServiceImpl  implements  UserAuthService{
    @Autowired
    UserAuthRespository userAuthRespository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDto createUser(UserDto user) {
        UserAuth userAuth=new UserAuth();
        BeanUtils.copyProperties(user,userAuth);
        userAuth.setUserid(890);

        UserDto userDto=new UserDto();
        userAuth.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userAuthRespository.save(userAuth);
BeanUtils.copyProperties(userAuth,userDto);

        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     UserAuth userAuth=userAuthRespository.findUserByEmail(email);
     if(userAuth==null) throw new EmployeeErrorHandling("STUDENT NOT FOUND");
        return new User(userAuth.getEmail(),userAuth.getPassword(),new ArrayList<>());
    }
}
