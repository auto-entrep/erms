package com.erms.app.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erms.app.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    public Employee updateEmployee(Long id, Employee e);
    //public Optional<Employee> findById(Long id);
    
    
    
	// Role findByRoleName(String roleName);
//	 @Query("select role from Role role")
	//Stream<Role> getAllRolesStream();
//	  Optional<User> findByLogin(String loginParam);
//		User findByLoginAndPassword(String login, String password); //méthode non utilisée pour le moment

	 


}
