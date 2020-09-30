package com.luv2code.springdemo.restapp.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ApplicationUser implements UserDetails {
    private final List<? extends GrantedAuthority> getAuthorities;
    private final String getPassword;
    private final String getUsername;
    private final Boolean isAccountNonExpired;
    private final Boolean isAccountNonLocked;
    private final Boolean isCredentialsNonExpired;
    private final Boolean  isEnabled;

    public ApplicationUser(List<? extends GrantedAuthority> getAuthorities, String getPassword, String getUsername, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean isEnabled) {
        this.getAuthorities = getAuthorities;
        this.getPassword = getPassword;
        this.getUsername = getUsername;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities;
    }

    @Override
    public String getPassword() {
        return getPassword;
    }

    @Override
    public String getUsername() {
        return getUsername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
