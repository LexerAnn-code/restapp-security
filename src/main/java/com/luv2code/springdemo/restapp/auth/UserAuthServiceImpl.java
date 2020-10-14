package com.luv2code.springdemo.restapp.auth;

import com.luv2code.springdemo.restapp.errorHandling.EmployeeErrorHandling;
import com.luv2code.springdemo.restapp.dto.UserDto;
import com.luv2code.springdemo.restapp.dto.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public void createUser(User user) {
         User storedEmail=userAuthRespository.findByEmail(user.getEmail());
        if(storedEmail!=null) throw new EmployeeErrorHandling("EMAIL EXISTS");
        //UserAuth userAuth=new UserAuth();
     //   BeanUtils.copyProperties(user,userAuth);
        String publicUserId=util.generateUserId(25);
        user.setUserid(publicUserId);
        UserDto userDto=new UserDto();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userAuthRespository.save(user);
     //   BeanUtils.copyProperties(userAuth,userDto);


    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     User userAuth=userAuthRespository.findByEmail(email);
     if(userAuth==null) throw new EmployeeErrorHandling("STUDENT NOT FOUND");
        return new org.springframework.security.core.userdetails.User(userAuth.getEmail(),userAuth.getPassword(),new ArrayList<>());
    }
}
