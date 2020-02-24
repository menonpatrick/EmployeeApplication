package com.employee.service;

import com.employee.dao.EmployeeDao;

public interface EmployeeService {

	EmployeeDao createOrUpdateEmployee(EmployeeDao employeeDao);
	EmployeeDao getEmployeeById(String id);

}
