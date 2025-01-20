package com.erms.app.security.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erms.app.security.entity.Role;
import com.erms.app.security.entity.User;
import com.erms.app.security.repository.RoleRepository;
import com.erms.app.security.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements  AccountService{

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User addNewUser(String username, String password, String email, String confirmPassword) {
		User user = userRepository.findByUsername(username);
		if(user!=null) throw new RuntimeException("this user already exist");
		if(password.equals(confirmPassword)) throw new RuntimeException("password not match");
		user = User.builder()
				.id(UUID.randomUUID().toString())
				.username(username)
				.password(password)
				.email(email)
				.build();
			User savedUser = userRepository.save(user);	
		
		return savedUser;
	}

	@Override
	public Role addNewRole(String role1) {
		Role role = roleRepository.findById(role1).orElse(null);
		if(role!=null) throw new RuntimeException("This role already exist");
	     role = Role.builder()
					.role(role1)
				.build();
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String role) {
User user = userRepository.findByUsername(username);
Role role1 = roleRepository.findById(role).get();
user.getRoles().add(role1);
		
	}

	@Override
	public void removeRoleFromeUser(String username, String role) {
		User user = userRepository.findByUsername(username);
		Role role1 = roleRepository.findById(role).get();
		user.getRoles().remove(role1);
		
	}

	@Override
	public User loadUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
