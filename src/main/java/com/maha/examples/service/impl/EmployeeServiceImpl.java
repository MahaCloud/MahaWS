package com.maha.examples.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maha.examples.exception.ResourceNotFoundException;
import com.maha.examples.model.Employee;
import com.maha.examples.repository.EmployeeRepository;
import com.maha.examples.service.EmployeeService;

//@Transaction NO need as Spring JPA provide transaction to all methods  
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	// @Autowired - If single constructor no need to add Autowired annotation coz spring automatically inject this dependency 
	//Injuct dependency. 1. Setter based for optional parameter 
	//2. Constructor based for mandatory parameters 
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		System.out.println("Employee Details in Service CLAss::" + employeeRepository.toString());
		return employeeRepository.save(employee);
		
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll(); // Its JPA OOB class
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Employee", "Id", id));
		
	}

	/*
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id)); 
		
		existingEmployee.
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
	*/
	
	@Override
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> //Lamda expression
								new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}
	

}
