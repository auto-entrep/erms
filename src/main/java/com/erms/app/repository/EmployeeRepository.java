package com.erms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erms.app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
