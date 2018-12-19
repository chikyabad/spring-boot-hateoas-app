package com.hateoas.app.services;

import java.util.List;
import com.hateoas.app.models.Department;

public interface DepartementService {

	Department createDepartment(Department d);
	Department findDepartmentById(String departmentId);
	void deleteDepartmentById(String departmentId);
	Department updateDepartmentById(Department d);
	List<Department> findAllDepartments();
	void deleteAllDepartments();

}
