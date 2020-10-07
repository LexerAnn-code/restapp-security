package com.luv2code.springdemo.restapp.rest;

import com.luv2code.springdemo.restapp.ErrorHandling.EmployeeErrorHandling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/accessdenied")
public class DeniedController {
public void deniedaccess(){
    new EmployeeErrorHandling("CANNOT DELETE AN INVALID EMPLOYEE");
}
}
