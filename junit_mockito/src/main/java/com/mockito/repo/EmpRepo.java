package com.mockito.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockito.dao.Emp;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Long> {

	Emp findById(long id);
}
