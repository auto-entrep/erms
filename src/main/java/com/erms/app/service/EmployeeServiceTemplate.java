package com.erms.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.erms.app.entity.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceTemplate {
    private static final String BASE_URL = "http://localhost:8085/employee";

    @Autowired private RestTemplate restTemplate;
//  @Autowired private PatientService restTemplate;
    
    public EmployeeServiceTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



  
    public List<Employee> findAll() {
    	Employee[] employees = restTemplate.getForObject(BASE_URL, Employee[].class);
        return Arrays.asList(employees);
    }

    public Optional<Employee> findById(Long id) {
    	Employee employee = restTemplate.getForObject(BASE_URL + "/" + id, Employee.class);
        return Optional.ofNullable(employee);
    }

    public Employee save(Employee employee) {
        return restTemplate.postForObject(BASE_URL, employee, Employee.class);
    }

    public void update(Long id, Employee employee) {
        restTemplate.put(BASE_URL + "/" + id, employee);
    }

    public void delete(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
