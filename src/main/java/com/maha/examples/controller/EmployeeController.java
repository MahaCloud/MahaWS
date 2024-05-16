package com.maha.examples.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maha.examples.model.Employee;
import com.maha.examples.service.EmployeeService;

//@@Controller
//@ResponseBody Instead of these 2 we use below controller
@RestController 
@RequestMapping("/api/employees")
// It Simplifies the necessity of adding @controller And Response Body on all APIs inside the controller
public class EmployeeController {

	private EmployeeService  employeeService;

	// Construcotr based dependency injection 
	public EmployeeController(EmployeeService  employeeService) {
		super();
		this.employeeService = employeeService;
	}
	// Build create employee REST API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		System.out.println("Employee Details::" + employee.toString());
		// Used overloaded constructor to pass HTTP response
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	
	// build get all employees REST API
		@GetMapping
		public List<Employee> getAllEmployees(){
			return employeeService.getAllEmployees();
		}
		
		
		// build get employee by id REST API
		// http://localhost:8080/api/employees/1
		@GetMapping("{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
			return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
		}
	
		
		
}
