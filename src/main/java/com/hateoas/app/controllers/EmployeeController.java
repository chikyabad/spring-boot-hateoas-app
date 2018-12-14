package com.hateoas.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hateoas.app.exceptions.ResourceNotFoundException;
import com.hateoas.app.models.Employee;
import com.hateoas.app.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAllEmployees();
	}

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/employees")
	public Employee createEmploye(@Valid @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
    
	@PutMapping(value="/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@Valid @RequestBody Employee employee) {
		try {
			return ResponseEntity.ok().body(employeeService.updateEmployeeById(employee));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") String id) {
		try {
			employeeService.deleteEmployeeById(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
