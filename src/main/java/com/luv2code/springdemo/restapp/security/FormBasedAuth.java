//package com.luv2code.springdemo.restapp.security;
//
//import com.luv2code.springdemo.restapp.auth.UserAuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import java.util.concurrent.TimeUnit;
//
//import static com.luv2code.springdemo.restapp.security.ApplicationUserPermission.*;
//import static com.luv2code.springdemo.restapp.security.ApplicationUserRole.*;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//
//public class FormBasedAuth extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
////                .antMatchers("/api/**").hasRole("")
//                //                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.getPermission())
////                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.getPermission())
////                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.getPermission())
////                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/management/api/v1/employees")
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))//Extending the remember me cookie to 21 days
//                .key("somethingsecured")
//                    .and()
//    .logout()
//    .logoutUrl("/logout")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
//    .clearAuthentication(true)
//    .invalidateHttpSession(true)
//    .deleteCookies("JSESSIONID","remember-me")
//    .logoutSuccessUrl("/login");//default for 2 weeks
//    }
//
////    @Override
////    @Bean
////    //Defining inMemory User
////    protected UserDetailsService userDetailsService() {
////        UserDetails admin= User.builder()
////                .username("admin")
////                .password(passwordEncoder.encode("Ken005Ann@") )
////                //.roles(ADMIN.name())
////                .authorities(ADMIN.getGrantedAuthorities())
////                .build();
////        UserDetails student=User.builder()
////                .username("employee")
////                .password(passwordEncoder.encode("005Ann@Ken"))
////                .authorities(EMPLOYEE.getGrantedAuthorities())
////                .build();
////        return new InMemoryUserDetailsManager(admin,student);
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService()
//    }
//}
