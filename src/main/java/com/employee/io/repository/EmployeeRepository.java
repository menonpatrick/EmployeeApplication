package com.employee.io.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.io.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
	EmployeeEntity findByEmpId(String id);

}
