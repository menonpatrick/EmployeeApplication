package com.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.io.EmployeeEntity;
import com.employee.io.repository.EmployeeRepository;

/**
 * 
 * @author Prateek
 *
 */
@Service
public class EmplpoyeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDao createEmployee(EmployeeDao employeeDao) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		EmployeeDao returnValue = new EmployeeDao();
		BeanUtils.copyProperties(employeeDao, employeeEntity);
		EmployeeEntity createdOrUpdatedEmployee = employeeRepository.save(employeeEntity);
		BeanUtils.copyProperties(createdOrUpdatedEmployee, returnValue);
		return returnValue;
	}

	@Override
	public EmployeeDao updateEmployee(String id, EmployeeDao employeeDao) {
		EmployeeDao returnValue = new EmployeeDao();
		EmployeeEntity employeeEntity = employeeRepository.findByEmpId(id);
		employeeEntity.setDepartment(employeeDao.getDepartment());
		employeeEntity.setFirstName(employeeDao.getFirstName());
		employeeEntity.setLastName(employeeDao.getLastName());
		EmployeeEntity updateddUserDetails = employeeRepository.save(employeeEntity);
		BeanUtils.copyProperties(updateddUserDetails, returnValue);
		return returnValue;
	}

	@Override
	public EmployeeDao getEmployeeById(String id) {
		EmployeeDao employeeDao = new EmployeeDao();
		EmployeeEntity employeeEntity = employeeRepository.findByEmpId(id);
		BeanUtils.copyProperties(employeeEntity, employeeDao);
		return employeeDao;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> allEmployees = new ArrayList<EmployeeEntity>();
		employeeRepository.findAll().forEach(allEmployees::add);
		return allEmployees;
	}

	@Override
	public void deleteEmployee(EmployeeDao employeeDao) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDao, employeeEntity);
		employeeRepository.delete(employeeEntity);

	}



}
