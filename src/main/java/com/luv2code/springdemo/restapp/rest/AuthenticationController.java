package com.luv2code.springdemo.restapp.rest;

import com.luv2code.springdemo.restapp.auth.User;
import com.luv2code.springdemo.restapp.auth.UserAuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/v1")
public class AuthenticationController {
@Autowired
UserAuthService userAuthService;
@PostMapping()
public String signup(@RequestBody User userReq){
    User userDto=new User();
  //  BeanUtils.copyProperties(userReq,userDto);

    ModelMapper modelMapper = new ModelMapper();
    User userDtos=modelMapper.map(userReq, User.class);

     userAuthService.createUser(userReq);
return "USER-CREATED-SUCCESSFULLY";
}


}
