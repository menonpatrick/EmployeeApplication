package com.employee.service;

import java.util.List;

import com.employee.dao.EmployeeDao;
import com.employee.io.EmployeeEntity;

public interface EmployeeService {

	EmployeeDao createOrUpdateEmployee(EmployeeDao employeeDao);
	EmployeeDao getEmployeeById(String id);
	List<EmployeeEntity> getAllEmployees();
	void deleteEmployee(EmployeeDao employeeDao);
	
}
