package com.employee.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.EmployeeDao;
import com.employee.model.EmployeeRequest;
import com.employee.model.EmployeeResponse;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value="/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping(value="/getTesting")
	public String getMethodTesting() {
		return "Get Method Test Passed!";
	}
	
	@PostMapping(value="/createEmployee")
	public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		EmployeeDao employeeDao = new EmployeeDao();
		BeanUtils.copyProperties(employeeRequest, employeeDao);
		EmployeeDao createdEmployee = employeeService.createOrUpdateEmployee(employeeDao);
		BeanUtils.copyProperties(createdEmployee, employeeResponse);
		return employeeResponse;
	}
	
}
