package com.erms.app.security.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erms.app.security.entity.User;
import com.erms.app.security.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




//@CrossOrigin(origins = "http://localhost:8085/", maxAge = 3600)
@RequestMapping("/api/auth")
@RestController
public class AuthentifController  {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserDetailsServiceImpl userDetailsServiceImpl;
  //  private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthentifController(UserDetailsServiceImpl userDetailsServiceImpl,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsServiceImpl= userDetailsServiceImpl;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    

    @PostMapping("/login")
    public String login(@RequestBody User authRequest) {
   /*     Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())        );*/
 //       SecurityContextHolder.getContext().setAuthentication(authentication);

    //    UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getLogin());
 
        
       UserDetails userDetails =userDetailsServiceImpl.loadUserByUsername(authRequest.getUsername());
        return "Authenticated as: " + userDetails.getUsername();
    }
      
  


//c'est un test
/*
        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestBody User loginRequest) {
            // Logique d'authentification
            if (authenticate(loginRequest.getLogin(), loginRequest.getPassword())) {
                System.out.println("Logique d'authentification: " );

                return ResponseEntity.ok("Authentication successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
            }
        }*/
/*
        private boolean authenticate(String username, String password) {
            // Exemple simplifié d'authentification
            return "user".equals(username) && "pass".equals(password);
        }*/
    }

    

    
    
    




