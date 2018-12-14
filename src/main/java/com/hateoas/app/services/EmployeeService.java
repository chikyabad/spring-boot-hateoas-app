package com.hateoas.app.services;

import java.util.List;

import com.hateoas.app.exceptions.ResourceNotFoundException;
import com.hateoas.app.models.Employee;

public interface EmployeeService {

	  Employee createEmployee(Employee e);      
	  Employee findEmployeeById(String employeeId) throws ResourceNotFoundException;    
	  void deleteEmployeeById(String employeeId) throws ResourceNotFoundException;      
	  Employee updateEmployeeById(Employee e) throws ResourceNotFoundException;          
	  List<Employee> findAllEmployees();      
	  void deleteAllEmployees(); 
	  
	  
}
