package com.employee.service;

import java.util.List;

import com.employee.dao.EmployeeDao;
import com.employee.io.EmployeeEntity;

/**
 * 
 * @author Prateek
 *
 */
public interface EmployeeService {

	EmployeeDao createEmployee(EmployeeDao employeeDao);
	EmployeeDao updateEmployee(String id, EmployeeDao employeeDao);
	EmployeeDao getEmployeeById(String id);
	List<EmployeeEntity> getAllEmployees();
	void deleteEmployee(EmployeeDao employeeDao);
	
}
