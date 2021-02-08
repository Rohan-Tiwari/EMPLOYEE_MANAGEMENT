package com.main.EmployeeManagement.repository;

import org.springframework.stereotype.Repository;

import com.main.EmployeeManagement.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
