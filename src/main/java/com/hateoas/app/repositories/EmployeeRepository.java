package com.hateoas.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hateoas.app.models.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
