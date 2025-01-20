package com.erms.app.security.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.erms.app.security.entity.Role;


public interface RoleRepository extends JpaRepository<Role, String> {
	
	 

}
