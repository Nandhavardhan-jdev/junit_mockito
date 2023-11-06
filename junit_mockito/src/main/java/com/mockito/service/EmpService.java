package com.mockito.service;

import com.mockito.dto.EmpDto;

public interface EmpService {

	Object addEmp(EmpDto empDto);
	Object getEmp(long id);
	Object deleteEmp(long id);
	Object updateEmp(EmpDto empDto);
	Object getAllEmps();

}
