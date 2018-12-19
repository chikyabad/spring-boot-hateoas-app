package com.hateoas.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hateoas.app.exceptions.ResourceNotFoundException;
import com.hateoas.app.models.Department;
import com.hateoas.app.repositories.DepartmentRepository;
import com.hateoas.app.services.DepartementService;

@Service
public class DepartmentServiceImpl implements DepartementService {
	
	@Autowired     
	private DepartmentRepository departmentRepository;  

	@Override
	public Department createDepartment(Department d) {
		return departmentRepository.save(d);
	}

	@Override
	public Department findDepartmentById(String departmentId){
		return departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department with id "+departmentId+" not found"));
	}

	@Override
	public void deleteDepartmentById(String departmentId){
		if (!departmentRepository.existsById(departmentId)){
			throw new ResourceNotFoundException("Department with id "+departmentId+" not found");
		}
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentById(Department d) {
		if (!departmentRepository.existsById(d.getDepartmentId())){
			throw new ResourceNotFoundException("Department with id "+d.getDepartmentId()+" not found");
		}
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
