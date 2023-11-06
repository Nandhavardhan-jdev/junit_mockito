package com.mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.dao.Emp;
import com.mockito.dto.EmpDto;
import com.mockito.service.EmpService;

@RestController
public class Controller {
	
	@Autowired
	EmpService empService;
	
	@PostMapping("/add/emp")
	public Object addEmp(@RequestBody EmpDto empDto) {
		return empService.addEmp(empDto);
	}
	@GetMapping("/get/emp/{id}")
	public Object getEmp(@PathVariable long id) {
		return empService.getEmp(id);
	}
	@DeleteMapping("/delete/emp/{id}")
	public Object deleteEmp(@PathVariable long id) {
		return empService.deleteEmp(id);
	}
	@PutMapping("/update/emp")
	public Object updateEmp(@RequestBody EmpDto empDto) {
		return empService.updateEmp(empDto);
	}
	@GetMapping("/get/all/emps")
	public Object getAllEmps() {
		return empService.getAllEmps();
	}

}
