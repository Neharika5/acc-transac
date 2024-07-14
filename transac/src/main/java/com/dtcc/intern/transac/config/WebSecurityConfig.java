package com.dtcc.intern.transac.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Bean
 public BCryptPasswordEncoder bCryptPasswordEncoder() {
     return new BCryptPasswordEncoder();
 }

 @Override
 protected void configure(HttpSecurity http) throws Exception {
     http.csrf().disable()
         .authorizeRequests()
         .antMatchers("/api/users/register", "/api/users/login").permitAll()
         .anyRequest().authenticated();
 }
}
