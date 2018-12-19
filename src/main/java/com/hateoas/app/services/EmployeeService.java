package com.hateoas.app.services;

import java.util.List;

import com.hateoas.app.models.Employee;

public interface EmployeeService {

	  Employee createEmployee(Employee e);      
	  Employee findEmployeeById(String employeeId);    
	  void deleteEmployeeById(String employeeId);      
	  Employee updateEmployeeById(Employee e); 
	  List<Employee> findAllEmployees();      
	  void deleteAllEmployees(); 
	    
}
