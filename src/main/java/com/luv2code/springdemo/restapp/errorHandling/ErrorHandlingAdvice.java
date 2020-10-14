package com.luv2code.springdemo.restapp.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingAdvice {
@ExceptionHandler
    public ResponseEntity<EmployeeError> handleException(Exception exception){
    EmployeeError employeeError=new EmployeeError(HttpStatus.NOT_FOUND.value(),exception.getLocalizedMessage(),System.currentTimeMillis());
return new ResponseEntity<>(employeeError,HttpStatus.BAD_GATEWAY);

}

    @ExceptionHandler
    public ResponseEntity<EmployeeError> handleException(EmployeeErrorHandling exception){
        EmployeeError employeeError=new EmployeeError(HttpStatus.NOT_FOUND.value(),exception.getLocalizedMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(employeeError,HttpStatus.NOT_FOUND);

    }
}
