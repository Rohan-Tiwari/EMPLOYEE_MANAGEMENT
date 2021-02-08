package com.main.EmployeeManagement.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.EmployeeManagement.exception.ResourceNotFoundException;
import com.main.EmployeeManagement.model.Employee;
import com.main.EmployeeManagement.model.Request;
import com.main.EmployeeManagement.repository.EmployeeRepository;
import com.main.EmployeeManagement.repository.RequestRepository;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("api/path1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RequestRepository requestRepository;
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll(); //returns a list of employees
	}
	@GetMapping("requests")
	public List<Request> getAllRequests(){
		return requestRepository.findAll(); //returns a list of employees
	}
	

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long employeeId)throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("Employee not found for this id ::" +employeeId));
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/employee")
	public Employee CreateEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	@PostMapping("/request")
	public Request CreateRequest(@Valid @RequestBody Request request) {
		return requestRepository.save(request);
	}
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
	         throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employeeId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not present for the id :: " + employeeId));

	        employeeRepository.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	@DeleteMapping("/requests/{id}")
	public Map<String, Boolean> deleteRequest(@PathVariable(value = "id") Integer id)
	         throws ResourceNotFoundException {
	        Request req = requestRepository.findById(id)
	       .orElseThrow(() -> new ResourceNotFoundException("Request not present for the id :: " + id));

	        requestRepository.delete(req);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
	@PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) throws    ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmail(employeeDetails.getEmail());
        employee.setFname(employeeDetails.getFname());
        employee.setLname(employeeDetails.getLname());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
