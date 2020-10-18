package com.luv2code.springdemo.restapp.dto;

import com.luv2code.springdemo.restapp.security.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import sun.security.util.SecurityConstants;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Component

public class Util {
private final Random RANDOM=new SecureRandom();
private final String ALPHABET="0123456789abcdefghijklmnopqrstuvwxzyABCDEFGHIJKLMNOPQRSTUVWXYZ";
private final int ITERATIONS=10000;
private final int KEY_LENGTH=256;


    public String generateUserId(int length){
    return  generateRandomString(length);
}
    public String generateAddressId(int length){
        return  generateRandomString(length);
    }

    private String generateRandomString(int length) {
StringBuilder returnValue=new StringBuilder(length);
for(int i=0;i<length;i++){
    returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
}
return new String(returnValue);
}
    public boolean hasTokenExpired(String token){
        Claims claims= Jwts.parser()
                .setSigningKey(SecurityConstant.TOKEN_SECRET)
                .parseClaimsJws(token).getBody();

        Date tokenExpirationDate=claims.getExpiration();
        Date todayDate=new Date();
        return tokenExpirationDate.before(todayDate);
    }

    public String generateEmailVerificationToken(String publicUserId) {

        String token=Jwts.builder()
                .setSubject(publicUserId)
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
                .signWith(Keys.hmacShaKeyFor(SecurityConstant.TOKEN_SECRET.getBytes()))
                .compact();

        return  token;

    }
}
