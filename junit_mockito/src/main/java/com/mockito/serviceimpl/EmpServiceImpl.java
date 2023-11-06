package com.mockito.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockito.dao.Emp;
import com.mockito.dto.EmpDto;
import com.mockito.repo.EmpRepo;
import com.mockito.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpRepo empRepo;

	@Override
	public Object addEmp(EmpDto empDto) {
		Emp emp2 = new Emp();
		emp2.setName(empDto.getName());
		empRepo.save(emp2);
		return empDaoToDto(emp2);
	}
	
	public Object empDaoToDto(Emp emp) {
		EmpDto empDto = new EmpDto();
		empDto.setId(emp.getId());
		empDto.setName(emp.getName());
		return empDto;
	}

	@Override
	public Object getEmp(long id) {
		Emp emp = empRepo.findById(id);
		return empDaoToDto(emp);
	}

	@Override
	public Object deleteEmp(long id) {
		empRepo.deleteById(id);
		return "deleted successfully";
	}

	@Override
	public Object updateEmp(EmpDto empDto) {
		Emp emp2 = empRepo.findById(empDto.getId());
		emp2.setName(empDto.getName());
		empRepo.save(emp2);
		return empDaoToDto(emp2);
	}

	@Override
	public Object getAllEmps() {
		List<Emp> emp = empRepo.findAll();
		List<Object> empDtos = emp.stream().map(new EmpServiceImpl()::empDaoToDto).toList();
		return empDtos;
	}
}
