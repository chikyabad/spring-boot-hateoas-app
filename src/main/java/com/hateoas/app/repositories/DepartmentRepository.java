package com.hateoas.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hateoas.app.models.Department;

public interface DepartmentRepository extends MongoRepository<Department,String>{

}
