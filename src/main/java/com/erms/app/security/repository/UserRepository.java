package com.erms.app.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erms.app.security.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String login); //méthode non utilisée pour le moment
 //   Optional<User> findByLogin(String loginParam);
//	@Query(value = "select user from User user where user.login = ?1 and user.password = ?2")
//	User findByLoginAndPassword(String login, String password); //méthode non utilisée pour le moment
//	User findByLogin(String login); 
	

}