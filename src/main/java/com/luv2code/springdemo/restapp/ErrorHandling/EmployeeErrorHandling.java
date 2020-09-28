package com.luv2code.springdemo.restapp.ErrorHandling;

public class EmployeeErrorHandling extends RuntimeException {
    public EmployeeErrorHandling(String message) {
        super(message);
    }
}
