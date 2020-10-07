package com.luv2code.springdemo.restapp.auth;

import com.google.common.base.Strings;
import com.luv2code.springdemo.restapp.security.SecurityConstant;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import sun.security.util.SecurityConstants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifier extends OncePerRequestFilter {
    //Invokes once for every request from the client
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       //Getting token from request
       String authorizationHeader=request.getHeader("Authorization");
       if(Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")){
        filterChain.doFilter(request,response);
        return;
       }
        String token=authorizationHeader.replace("Bearer ","");
        try{
           Jws<Claims> claimsJws = Jwts.parser()
                   .setSigningKey(Keys.hmacShaKeyFor(SecurityConstant.TOKEN_SECRET.getBytes()))
                   .parseClaimsJws(token);
           Claims body=claimsJws.getBody();
           String username = body.getSubject();

//           List authorities=(List<Map<String,String>>) body.get("authorities");
//
//            Set<SimpleGrantedAuthority> simpleGrantedAuthorities=authorities.stream()
//                    .map(m -> new SimpleGrantedAuthority(m("authorities")))
//                    .collect(Collectors.toSet());

           Authentication authentication=new UsernamePasswordAuthenticationToken(username,null,null);

           SecurityContextHolder.getContext().setAuthentication(authentication);

       }

       catch (JwtException e){
           throw new IllegalStateException("Invalid  token" + token);
       }
        filterChain.doFilter(request,response);


    }
}
