package com.hateoas.app.services;

import java.util.List;

import com.hateoas.app.exceptions.ResourceNotFoundException;
import com.hateoas.app.models.Department;

public interface DepartementService {

	Department createDepartment(Department d);
	Department findDepartmentById(String departmentId) throws ResourceNotFoundException;
	void deleteDepartmentById(String departmentId) throws ResourceNotFoundException;
	Department updateDepartmentById(Department d) throws ResourceNotFoundException;
	List<Department> findAllDepartments();
	void deleteAllDepartments();

}
