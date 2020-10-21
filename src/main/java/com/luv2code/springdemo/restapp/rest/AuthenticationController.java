package com.luv2code.springdemo.restapp.rest;

import com.luv2code.springdemo.restapp.auth.UserAuthService;
import com.luv2code.springdemo.restapp.auth.UserReq;
import com.luv2code.springdemo.restapp.dto.UserDto;
import com.luv2code.springdemo.restapp.passwordReset.PasswordRequestModel;
import com.luv2code.springdemo.restapp.passwordReset.PasswordRequestModelNew;
import com.luv2code.springdemo.restapp.util.OperationStatusModel;
import com.luv2code.springdemo.restapp.util.RequestOperationName;
import com.luv2code.springdemo.restapp.util.RequestOperationStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
@Autowired
UserAuthService userAuthService;
@PostMapping(path = "/signup")
public String signup(@RequestBody UserReq userReq){

  //  BeanUtils.copyProperties(userReq,userDto);

    ModelMapper modelMapper = new ModelMapper();
    UserDto userDto=modelMapper.map(userReq, UserDto.class);

     userAuthService.createUser(userDto);
return "USER-CREATED-SUCCESSFULLY";
}
    @GetMapping("/email-verification")
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
    @PostMapping("/password-reset")
    public OperationStatusModel passwordReset(@RequestBody PasswordRequestModel passwordRequestModel){
        OperationStatusModel operationStatusModel=new OperationStatusModel();
        operationStatusModel.setOperationName(RequestOperationName.PASSWORD_RESET.name());
        boolean passwordResetResults=userAuthService.passwordReset(passwordRequestModel.getEmail());

        if(passwordResetResults){
            operationStatusModel.setOperationResults(RequestOperationStatus.SUCCESS.name());

        }
        else {
            operationStatusModel.setOperationResults(RequestOperationStatus.ERROR.name());

        }
        return operationStatusModel;
    }

    @PostMapping("/password-reset-reset")
    public OperationStatusModel passwordResetPassword(@RequestBody PasswordRequestModelNew passwordReq){
        OperationStatusModel operationStatusModel=new OperationStatusModel();
        operationStatusModel.setOperationName(RequestOperationName.PASSWORD_RESET_NEW.name());
        boolean passwordResetResults=userAuthService.passwordResetnew(passwordReq.getToken(),passwordReq.getPasswordtyped());

        if(passwordResetResults){
            operationStatusModel.setOperationResults(RequestOperationStatus.SUCCESS.name());

        }
        else {
            operationStatusModel.setOperationResults(RequestOperationStatus.ERROR.name());

        }
        return operationStatusModel;
    }

}
