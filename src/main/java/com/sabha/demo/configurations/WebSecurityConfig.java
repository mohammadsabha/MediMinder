package com.sabha.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorize) -> authorize
            		.requestMatchers("/admin/**").hasRole("ADMIN")
//            		.requestMatchers("/", "/home").authenticated()
	                .anyRequest().permitAll()
            )
            .formLogin(login -> login
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
                )
            .logout(logout -> logout
                    .permitAll()
                );
        return http.build();
    }
    
    
}
