package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
@Component(value = "userDetailService")
public class UserDetailService implements UserDetailsService{
@Autowired
private UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username)  {
		System.out.println("hello ");
        if(userRepository.count()==0){
      
        	userRepository.save(new User( "admin", passwordEncoder.encode("admin"), Arrays.asList(new Role("USER"),new Role("Actuator")) ));
       }
		CustomUserDetailsService user = new CustomUserDetailsService(userRepository.findByUsername(username));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
	}
	

}
