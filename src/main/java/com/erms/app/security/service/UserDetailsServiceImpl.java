package com.erms.app.security.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.erms.app.security.entity.Role;
import com.erms.app.security.entity.User;
import com.erms.app.security.repository.UserRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


	private AccountService accountService;
	
   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = accountService.loadUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException(String.format("User %s not found", username));
       String[] roles = user.getRoles().stream().map(u->u.getRole()).toArray(String[]::new);

       UserDetails userDetails = org.springframework.security.core.userdetails.User
    		   .withUsername(user.getUsername())
    		   .password(user.getPassword())
    		   .roles(roles).build();
        return userDetails;
        
    } 
        
		
		
    
    private List<GrantedAuthority> getGrantedAuthorities(Set<Role> role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }
	
	

	
	 private List<GrantedAuthority> getGrantedAuthorities(String role) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            return authorities;
        }
		
}
