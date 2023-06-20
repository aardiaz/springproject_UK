package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bway.springproject.model.Employee;
import com.bway.springproject.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/add")
	public String getEmployee() {

		return "EmployeeForm";
	}

	@PostMapping("/add")
	public String postEmployee(@ModelAttribute Employee employee) {

		empService.addEmp(employee);
		
		return "EmployeeForm";
	}
}
