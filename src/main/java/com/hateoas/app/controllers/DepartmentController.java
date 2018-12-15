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
import com.hateoas.app.models.Department;
import com.hateoas.app.models.Employee;
import com.hateoas.app.services.DepartementService;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	private DepartementService departmentService;
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return departmentService.findAllDepartments();
	}
	
	@GetMapping(value = "/departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok().body(departmentService.findDepartmentById(id));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/departments")
	public Department createDepartment(@Valid @RequestBody Department department) {
		return departmentService.createDepartment(department);
	}
	
	@PutMapping(value="/departments/{id}")
	public ResponseEntity<Department> updateEmployeeById(@PathVariable("id") String id, @Valid @RequestBody Department department) {
		try {
			department.setDepartmentId(id);
			return ResponseEntity.ok().body(departmentService.updateDepartmentById(department));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value = "/departments/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id") String id) {
		try {
			departmentService.deleteDepartmentById(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
