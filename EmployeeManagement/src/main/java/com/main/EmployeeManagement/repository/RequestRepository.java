package com.main.EmployeeManagement.repository;

import org.springframework.stereotype.Repository;

import com.main.EmployeeManagement.model.Employee;
import com.main.EmployeeManagement.model.Request;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{
	
}
