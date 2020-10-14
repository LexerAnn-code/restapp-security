package com.luv2code.springdemo.restapp.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthHandlingAdvice {
//@ExceptionHandler
//    public ResponseEntity<AuthHttpResponse> handleException(Exception exception){
//    AuthHttpResponse authHttpResponse=new AuthHttpResponse(HttpStatus.ACCEPTED.value(),exception.getLocalizedMessage(),System.currentTimeMillis());
//return new ResponseEntity<>(authHttpResponse,HttpStatus.ACCEPTED);
//
//}

    @ExceptionHandler
    public ResponseEntity<AuthHttpResponse> handleException(AuthErrorHandling exception){
        AuthHttpResponse authHttpResponse=new AuthHttpResponse(HttpStatus.OK.value(),exception.getLocalizedMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(authHttpResponse,HttpStatus.OK);

    }
}
