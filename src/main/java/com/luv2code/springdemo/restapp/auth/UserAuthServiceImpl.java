package com.luv2code.springdemo.restapp.auth;

import com.luv2code.springdemo.restapp.errorHandling.EmployeeErrorHandling;
import com.luv2code.springdemo.restapp.dto.UserDto;
import com.luv2code.springdemo.restapp.dto.Util;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
    public void createUser(UserDto user) {
         User storedEmail=userAuthRespository.findByEmail(user.getEmail());
        if(storedEmail!=null) throw new EmployeeErrorHandling("EMAIL EXISTS");
        //UserAuth userAuth=new UserAuth();
     //   BeanUtils.copyProperties(user,userAuth);
        String publicUserId=util.generateUserId(25);
        user.setUserid(publicUserId);
        user.setEmailVerificationToken(util.generateEmailVerificationToken(publicUserId));
        user.setEmailVerificationStatus(false);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        ModelMapper modelMapper=new ModelMapper();
        User userSignup=modelMapper.map(user,User.class);

        userAuthRespository.save(userSignup);
     //   BeanUtils.copyProperties(userAuth,userDto);


    }

    @Override
    public boolean verifyEmailToken(String token) {
        boolean returnValue=false;
        User user=userAuthRespository.findUserByEmailVerificationToken(token);
        if(token!=null){
            boolean hasTokenExpired=util.hasTokenExpired(token);
            if(!hasTokenExpired){
                user.setEmailVerificationToken(null);
                user.setEmailVerificationStatus(Boolean.TRUE);
                returnValue=true;
            }
        }
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     User userAuth=userAuthRespository.findByEmail(email);

     if(userAuth==null) throw new EmployeeErrorHandling("STUDENT NOT FOUND");//If the Email is not verified it is not saved in the database
       return new org.springframework.security.core.userdetails.User(userAuth.getEmail(),userAuth.getPassword(), userAuth.getEmailVerificationStatus(),
        true,true,
        true, new ArrayList<>());

    }
}
