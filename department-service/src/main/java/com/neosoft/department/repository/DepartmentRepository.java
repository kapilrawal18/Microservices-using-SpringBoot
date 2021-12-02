package com.neosoft.department.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.department.enity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Long>{

	Department findByDepartmentId(Long departmentId);
}
