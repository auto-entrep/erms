package com.erms.app.security.service;

import com.erms.app.security.entity.Role;
import com.erms.app.security.entity.User;

public interface AccountService {
	
	User addNewUser(String username, String password, String email, String confirmPassword);
	Role addNewRole(String Role);
	void addRoleToUser(String username, String role);
	void removeRoleFromeUser(String username, String role);
    User loadUserByUsername(String username);
}
