package com.luv2code.springdemo.restapp.security;

import com.luv2code.springdemo.restapp.auth.JwtTokenVerifier;
import com.luv2code.springdemo.restapp.auth.JwtUsernameAndPassword;
import com.luv2code.springdemo.restapp.auth.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFilter;

import static com.luv2code.springdemo.restapp.security.ApplicationUserRole.ADMIN;

@Configuration
@EnableWebSecurity
public class FormWellBasedAuth extends WebSecurityConfigurerAdapter {
    @Autowired
    public UserAuthService userAuthService;
    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login","/auth/*","/","/api/v1/email-verification").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtUsernameAndPassword(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(),JwtUsernameAndPassword.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder);
    }



}
