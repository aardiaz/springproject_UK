package com.bway.springproject.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.Department;
import com.bway.springproject.repository.DepartmentRepository;
import com.bway.springproject.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements  DepartmentService{
	
	@Autowired
	private DepartmentRepository  deptRepo;

	@Override
	public void addDept(Department dept) {
		 deptRepo.save(dept);
	}

	@Override
	public void deleteDept(int deptId) {
		deptRepo.deleteById(deptId);
	}

	@Override
	public void updateDept(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public Department getDeptById(int deptId) {
		 
		return deptRepo.findById(deptId).get();
	}

	@Override
	public List<Department> getAllDepts() {
		 
		return deptRepo.findAll();
	}

}
