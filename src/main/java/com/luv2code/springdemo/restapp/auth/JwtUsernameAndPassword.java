package com.luv2code.springdemo.restapp.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.springdemo.restapp.security.SecurityConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sun.security.util.SecurityConstants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDate;
import java.util.Date;

public class JwtUsernameAndPassword extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;


    public JwtUsernameAndPassword(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //Getting email and password sent by the client

        try{
            //Reads email and password from the UserLoginReq.class
            UserLoginReq authenticationRequest=new ObjectMapper()
                    .readValue(request.getInputStream(),UserLoginReq.class);

                //Authenticating Email and Password
            Authentication  authentication=new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()
            );
            Authentication authenticate= authenticationManager.authenticate(authentication);
            return authenticate;


        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    //Creating the token to be sent to client
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(authResult.getName())//getting name of authResults
                .claim("authorities",authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(SignatureAlgorithm.HS512,SecurityConstant.TOKEN_SECRET)
                .compact();
        //Adding token to response header
        response.addHeader("Authorization","Bearer " + token);


    }
}
