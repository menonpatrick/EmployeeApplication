package com.employee.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.io.EmployeeEntity;
import com.employee.io.repository.EmployeeRepository;

@Service
public class EmplpoyeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRespository;

	@Override
	public EmployeeDao createOrUpdateEmployee(EmployeeDao employeeDao) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		EmployeeDao returnValue = new EmployeeDao();
		BeanUtils.copyProperties(employeeDao, employeeEntity);
		EmployeeEntity createdOrUpdatedEmployee = employeeRespository.save(employeeEntity);
		BeanUtils.copyProperties(createdOrUpdatedEmployee, returnValue);
		return returnValue;
	}

}
