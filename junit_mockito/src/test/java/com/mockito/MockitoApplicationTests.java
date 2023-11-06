package com.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mockito.dao.Emp;
import com.mockito.dto.EmpDto;
import com.mockito.repo.EmpRepo;
import com.mockito.service.EmpService;

@SpringBootTest
class MockitoApplicationTests {

	@Autowired
	EmpService empService;
	
	@MockBean
	EmpRepo empRepo;
	
	@Test
	void addEmpTest() {
		EmpDto empDto = new EmpDto(0, "a");
		assertEquals(empDto.toString(),empService.addEmp(empDto).toString());
	}
	@Test
	void getEmpTest() {
		Emp emp = new Emp(1, "a");
		when(empRepo.findById(1)).thenReturn(emp);
		assertEquals(emp.toString(), empService.getEmp(1).toString());
	}
	@Test
	void deleteEmpTest() {
		empService.deleteEmp(1);
		verify(empRepo, times(1)).deleteById((long) 1);
//		assertEquals("deleted successfully", empService.deleteEmp(1));
	}
	@Test
	void updateEmpTest() {
		Emp emp = new Emp(1,"a");
		EmpDto updatingEmp = new EmpDto(1,"b");
		when(empRepo.findById(1)).thenReturn(emp);
		assertEquals(updatingEmp.toString(), empService.updateEmp(updatingEmp).toString());
	}
	@Test
	void getAllEmpsTest() {
		List<Emp> emps = List.of(new Emp(1, "a"),new Emp(2, "b"));
		when(empRepo.findAll()).thenReturn(emps);
		assertEquals(emps.toString(), empService.getAllEmps().toString());
	}

}
