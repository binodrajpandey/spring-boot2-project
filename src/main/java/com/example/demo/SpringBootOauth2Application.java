package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ClientDetails.class)
public class SpringBootOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauth2Application.class, args);
	}
//        @Autowired
//        public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception{
//            System.out.println("hello ");
//            if(repo.count()==0){
//          
//               repo.save(new User( "admin", passwordEncoder.encode("admin"), Arrays.asList(new Role("USER"),new Role("Actuator")) ));
//               System.out.println("saved");
//           }
//            builder.userDetailsService((username)-> {
//                return new CustomUserDetailsService(repo.findByUsername(username));
//            }
//            );
//        }
}
