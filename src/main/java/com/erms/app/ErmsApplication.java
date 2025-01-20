package com.erms.app;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.erms.app.entity.Employee;
import com.erms.app.security.service.AccountService;
import com.erms.app.security.service.UserDetailsServiceImpl;
import com.erms.app.service.EmployeeService;

@SpringBootApplication
@ComponentScan(basePackages = "com.erms.app")
public class ErmsApplication {
	

    @Autowired
	private	UserDetailsServiceImpl userDetailsServiceImpl;
	
    
    public static void main(String[] args) {
		SpringApplication.run(ErmsApplication.class, args);
	}
    
/*	@Bean
	CommandLineRunner commandLineRunner(EmployeeService employeeService) {
		return args->{

			Employee employee1= Employee.builder()
	                   .fullName("fullname")
	                   .jobTitle("jobtitle")
	                   .department("departement")
	                   .hireDate(LocalDate.now())
	                   .employmentStatus("employementstatus")
	                   .contactInfo("contactInfo")
	                   .address("address")
	                   .role("role")
	                   .build();
			employeeService.createEmployee(employee1);
			
			Employee employee2= Employee.builder()
	                   .fullName("fullname2")
	                   .jobTitle("jobtitle2")
	                   .department("departement2")
	                   .hireDate(LocalDate.now())
	                   .employmentStatus("employementstatus2")
	                   .contactInfo("contactInfo2")
	                   .address("address2")
	                   .role("role2")
	                   .build();
			employeeService.createEmployee(employee2);	                   
	                   

					
					
		};
	}*/
	
	@Bean
	CommandLineRunner commandLineRunner(AccountService accountService) {
		return args->{

			accountService.addNewRole("USER");
			accountService.addNewRole("ADMIN");
			accountService.addNewUser("user1", "1234", "user1@gmail.com", "1234");
			accountService.addNewUser("user2", "1234", "user2@gmail.com", "1234");
			accountService.addNewUser("admin", "1234", "admin@gmail.com", "1234");
			
			accountService.addRoleToUser("user1", "USER");
			accountService.addRoleToUser("user2", "USER");
			accountService.addRoleToUser("admin", "ADMIN");
			accountService.addRoleToUser("admin", "USER");

					
					
		};
	}
	
/*	@Bean
	CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcusUserDetailsManager) {
             PasswordEncoder passwordEncoder=passwordEncoder();
		return args->{
			UserDetails u1 = jdbcusUserDetailsManager.loadUserByUsername("user11");
              if(u1==null)
            	  jdbcusUserDetailsManager.createUser(
              User.withUsername("user11").password(passwordEncoder.encode("1234")).roles("USER").build()
            		 );
              
              UserDetails u2 = jdbcusUserDetailsManager.loadUserByUsername("user22");
              if(u2==null)
            	  jdbcusUserDetailsManager.createUser(
              User.withUsername("user22").password(passwordEncoder.encode("1234")).roles("USER").build()
            		 );
              
              
              UserDetails u3 = jdbcusUserDetailsManager.loadUserByUsername("admin2");
              if(u3==null)
            	  jdbcusUserDetailsManager.createUser(
              User.withUsername("admin2").password(passwordEncoder.encode("1234")).roles("USER").build()
            		 );
              		};
	}*/
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
