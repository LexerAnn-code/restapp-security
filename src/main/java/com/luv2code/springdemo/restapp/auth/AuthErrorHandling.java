package com.luv2code.springdemo.restapp.auth;

public class AuthErrorHandling extends RuntimeException {
    private static final long serialVersionUID = -8139662532786820634L;

    public AuthErrorHandling(String message) {
        super(message);
    }
}
