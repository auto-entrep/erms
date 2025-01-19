package com.erms.app;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.erms.app.entity.Employee;
import com.erms.app.service.EmployeeService;

@SpringBootApplication
public class ErmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErmsApplication.class, args);
	}
    
	@Bean
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
	}

}
