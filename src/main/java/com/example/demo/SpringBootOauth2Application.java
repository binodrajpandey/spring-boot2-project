package com.example.demo;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(ClientDetails.class)
public class SpringBootOauth2Application {
	 @Autowired
	    private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauth2Application.class, args);
	}
        @Autowired
        public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception{
            System.out.println("hello ");
            if(repo.count()==0){
          
               repo.save(new User( "admin", passwordEncoder.encode("admin"), Arrays.asList(new Role("USER"),new Role("Actuator")) ));
               System.out.println("saved");
           }
            builder.userDetailsService((username)-> {
                return new CustomUserDetailsService(repo.findByUsername(username));
            }
            );
        }
}
