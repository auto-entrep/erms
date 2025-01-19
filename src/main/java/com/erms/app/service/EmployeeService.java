package com.erms.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erms.app.entity.Employee;
import com.erms.app.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId);
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}
	
	public Employee updateEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	public void deleteEmployee(String employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
