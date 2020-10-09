package com.luv2code.springdemo.restapp.rest;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.luv2code.springdemo.restapp.auth.JwtUsernameAndPassword;
import com.luv2code.springdemo.restapp.auth.UserAuthService;
import com.luv2code.springdemo.restapp.auth.UserReq;
import com.luv2code.springdemo.restapp.dto.UserDto;
import org.springframework.beans.BeanUtils;
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
public String signup(@RequestBody UserReq userReq){
    UserDto userDto=new UserDto();
    BeanUtils.copyProperties(userReq,userDto);
     userAuthService.createUser(userDto);
return "USER-CREATED-SUCCESSFULLY";
}


}
