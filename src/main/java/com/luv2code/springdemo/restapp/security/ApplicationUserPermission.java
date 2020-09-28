package com.luv2code.springdemo.restapp.security;

public enum ApplicationUserPermission {
EMPLOYEE_READ("employees:read"),
EMPLOYEE_WRITE("employees:write"),
ADMIN_READ("admin:read"),
ADMIN_WRITE("admin:write");

    private String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
