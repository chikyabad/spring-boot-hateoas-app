package com.hateoas.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hateoas.app.exceptions.ResourceNotFoundException;
import com.hateoas.app.models.Employee;
import com.hateoas.app.repositories.EmployeeRepository;
import com.hateoas.app.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	    
  @Autowired     
  private EmployeeRepository employeeRepository;  
  
  @Override     
  public Employee createEmployee(Employee e) {         
    return employeeRepository.insert(e);
  }  
  
  @Override     
  public Employee findEmployeeById(String employeeId) {     
    return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with id "+ employeeId+" not found"));
  } 
  
  @Override     
  public void deleteEmployeeById(String employeeId) {  
	if (!employeeRepository.existsById(employeeId)){
		throw new ResourceNotFoundException("Employee with id "+ employeeId+" not found");
	}
	employeeRepository.deleteById(employeeId);
  }    
  
  @Override     
  public Employee updateEmployeeById(Employee e) {    
	if (!employeeRepository.existsById(e.getEmployeeId())){
		throw new ResourceNotFoundException("Employee with "+ e.getEmployeeId()+" not found");
	}
    return employeeRepository.save(e);   
  }   
   
  @Override     
  public List<Employee> findAllEmployees() {         
    return employeeRepository.findAll();     
  }   
  
  @Override     
  public void deleteAllEmployees() {         
    employeeRepository.deleteAll();     
  } 
}
