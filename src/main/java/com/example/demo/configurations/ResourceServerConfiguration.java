/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *
 * @author binod
 */
@Configuration
@EnableResourceServer

public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/students/**").permitAll()
                  .antMatchers("/departments/**").permitAll()
                .anyRequest().authenticated();
//                .antMatchers(HttpMethod.OPTIONS,"/oauth/token").permitAll()
//                .antMatchers("/user/**").authenticated();
    } 
}
