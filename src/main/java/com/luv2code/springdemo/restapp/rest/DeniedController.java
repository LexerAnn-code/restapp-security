package com.luv2code.springdemo.restapp.rest;

import com.luv2code.springdemo.restapp.errorHandling.EmployeeErrorHandling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accessdenied")
public class DeniedController {
public void deniedaccess(){
    new EmployeeErrorHandling("CANNOT DELETE AN INVALID EMPLOYEE");
}
}
