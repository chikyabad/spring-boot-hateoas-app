package com.hateoas.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.hateoas.app.models.Department;
import com.hateoas.app.repositories.DepartmentRepository;
import com.hateoas.app.services.DepartementService;

@Service
public class DepartmentService implements DepartementService {
	
	@Autowired     
	private DepartmentRepository departmentRepository;  

	@Override
	public Department createDepartment(Department d) {
		return departmentRepository.save(d);
	}

	@Override
	public Department findDepartmentById(String departmentId) {
		return departmentRepository.findById(departmentId).orElse(null);
	}

	@Override
	public void deleteDepartmentById(String departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentById(Department d) {
		return departmentRepository.save(d);
	}

	@Override
	public List<Department> findAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public void deleteAllDepartments() {
		departmentRepository.deleteAll();

	}

}
