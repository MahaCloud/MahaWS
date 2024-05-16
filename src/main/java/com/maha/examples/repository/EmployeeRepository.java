package com.maha.examples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maha.examples.model.Employee;

// No need to have @Repository and @Transaction annotation as its imp calss already provides
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	
}
