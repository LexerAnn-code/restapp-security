package com.luv2code.springdemo.restapp.errorHandling;

public class EmployeeErrorHandling extends RuntimeException {
    public EmployeeErrorHandling(String message) {
        super(message);
    }
}
