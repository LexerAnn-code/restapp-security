//package com.luv2code.springdemo.restapp.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import static com.luv2code.springdemo.restapp.security.ApplicationUserPermission.*;
//import static com.luv2code.springdemo.restapp.security.ApplicationUserRole.*;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class BasicAuthSecurity extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
////                .antMatchers("/api/**").hasRole("")
//    //                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.getPermission())
////                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.getPermission())
////                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.getPermission())
////                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//
//    @Override
//    @Bean
//    //Defining inMemory User
//    protected UserDetailsService userDetailsService() {
//        UserDetails admin= User.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("Ken005Ann@") )
//                //.roles(ADMIN.name())
//                .authorities(ADMIN.getGrantedAuthorities())
//                .build();
//        UserDetails student=User.builder()
//                .username("employee")
//                .password(passwordEncoder.encode("005Ann@Ken"))
//                .authorities(EMPLOYEE.getGrantedAuthorities())
//                .build();
//    return new InMemoryUserDetailsManager(admin,student);
//    }
//}
