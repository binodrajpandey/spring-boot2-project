package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author binod
 */
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	//
	// http
	// .cors()
	// .and().csrf().disable();
	//
	// }
	//
	// @Bean
	// public CorsConfigurationSource corsConfigurationSource() {
	// CorsConfiguration configuration = new CorsConfiguration();
	// configuration.setAllowedOrigins(Arrays.asList("*"));
	// configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH",
	// "DELETE", "OPTIONS"));
	// configuration.setAllowedHeaders(Arrays.asList("authorization",
	// "content-type", "x-auth-token"));
	// configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	// UrlBasedCorsConfigurationSource source = new
	// UrlBasedCorsConfigurationSource();
	// source.registerCorsConfiguration("/**", configuration);
	// return source;
	// }
	// @Bean
	// @Override
	// public AuthenticationManager authenticationManagerBean() throws Exception {
	// AuthenticationManager authenticationManager=authenticationManagerBean();
	// return authenticationManager;
	// }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Qualifier("userDetailService")
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	/**
	 * you don't have to explicitly define Authentication manager bean for
	 * springboot 1.*.* versions
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
