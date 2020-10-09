package com.luv2code.springdemo.restapp.auth;

import com.luv2code.springdemo.restapp.ErrorHandling.EmployeeErrorHandling;
import com.luv2code.springdemo.restapp.dto.UserDto;
import com.luv2code.springdemo.restapp.dto.Util;
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
    @Autowired
    Util util;
    @Override
    public void createUser(UserDto user) {
         UserAuth storedEmail=userAuthRespository.findByEmail(user.getEmail());
        if(storedEmail!=null) throw new EmployeeErrorHandling("EMAIL EXISTS");

        UserAuth userAuth=new UserAuth();
        BeanUtils.copyProperties(user,userAuth);
        String publicUserId=util.generateUserId(25);
        userAuth.setUserid(publicUserId);
        UserDto userDto=new UserDto();
        userAuth.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userAuthRespository.save(userAuth);
        BeanUtils.copyProperties(userAuth,userDto);


    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     UserAuth userAuth=userAuthRespository.findByEmail(email);
     if(userAuth==null) throw new EmployeeErrorHandling("STUDENT NOT FOUND");
        return new User(userAuth.getEmail(),userAuth.getPassword(),new ArrayList<>());
    }
}
