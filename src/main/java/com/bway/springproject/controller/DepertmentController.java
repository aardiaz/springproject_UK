package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bway.springproject.model.Department;
import com.bway.springproject.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepertmentController {
	
	@Autowired
	private DepartmentService  deptService;

	  @GetMapping("/add")
	  public String getDeptForm() {
		  
		  return "DepartmentForm";
	  }
	  
	  @PostMapping("/add")
	  public String postDept(@ModelAttribute Department  dept) {
		  
		    deptService.addDept(dept);
		  
		  return "DepartmentForm";
	  }
	  
	  @GetMapping("/list")
	  public String getAll(Model model) {
		  
		  model.addAttribute("dlist",deptService.getAllDepts());
		  return "DepartmentListForm";
	  }
	  
}
