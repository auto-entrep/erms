package com.erms.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;

import com.erms.app.security.service.UserDetailsServiceImpl;

import javax.sql.DataSource;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig  {
 
	
	private UserDetailsServiceImpl userDetailsServiceImpl; 
    private PasswordEncoder passwordEncoder;
    
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource datasource) {
    	return new JdbcUserDetailsManager(datasource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests            		
                	.requestMatchers("/api/auth/**").hasAnyRole("USER", "ADMIN")
                	.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")  // Accessible aux utilisateurs avec les rôles USER ou ADMIN
                    .requestMatchers("/admin/**").hasRole("ADMIN")  // Accessible uniquement aux utilisateurs avec le rôle ADMIN
                    .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/**", "/h2-console/**", "/favicon.ico").permitAll()  // Accès permis à tout le monde
                    .anyRequest().authenticated()  // Toute autre demande nécessite une authentification
                )
                .userDetailsService(userDetailsServiceImpl)
                .formLogin(formLogin -> formLogin
                		
                    .loginPage("/login")  // Spécifie la page de connexion personnalisée
                    .permitAll()
                )
                .logout(logout -> logout
                    .permitAll()
                )
                .headers(headers -> headers
                    .frameOptions(frameOptions -> frameOptions.disable())
                )
                .build();
    }
    
    
    
   

    
    
    

    	
}
