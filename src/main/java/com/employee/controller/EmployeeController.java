package com.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/employees")
public class EmployeeController {

	@GetMapping(value="/getTesting")
	public String getMethodTesting() {
		return "Get Method Test Passed!";
	}
	
	
}
