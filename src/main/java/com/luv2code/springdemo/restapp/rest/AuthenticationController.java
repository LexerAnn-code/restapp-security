package com.luv2code.springdemo.restapp.rest;

import com.luv2code.springdemo.restapp.auth.User;
import com.luv2code.springdemo.restapp.auth.UserAuthService;
import com.luv2code.springdemo.restapp.auth.UserReq;
import com.luv2code.springdemo.restapp.dto.UserDto;
import com.luv2code.springdemo.restapp.util.OperationStatusModel;
import com.luv2code.springdemo.restapp.util.RequestOperationName;
import com.luv2code.springdemo.restapp.util.RequestOperationStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/v1")
public class AuthenticationController {
@Autowired
UserAuthService userAuthService;
@PostMapping()
public String signup(@RequestBody UserReq userReq){

  //  BeanUtils.copyProperties(userReq,userDto);

    ModelMapper modelMapper = new ModelMapper();
    UserDto userDto=modelMapper.map(userReq, UserDto.class);

     userAuthService.createUser(userDto);
return "USER-CREATED-SUCCESSFULLY";
}
    @GetMapping(path = "/email-verification")
    public OperationStatusModel verifyEmailToken(@RequestParam(value = "token") String token){
        OperationStatusModel operationStatusModel=new OperationStatusModel();
        operationStatusModel.setOperationName(RequestOperationName.VERIFY_EMAIL.name());
        boolean isVerified=userAuthService.verifyEmailToken(token);
        if(isVerified){
            operationStatusModel.setOperationResults(RequestOperationStatus.SUCCESS.name());
        }
        else {
            operationStatusModel.setOperationResults(RequestOperationStatus.ERROR.name());
        }

        return operationStatusModel;
    }

}
