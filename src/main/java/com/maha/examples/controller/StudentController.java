package com.maha.examples.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.maha.examples.model.StudentBean;

@RestController
public class StudentController {

	//@GetMapping(path="/restapi/student", produces = {MediaType.APPLICATION_XML_VALUE}  )
	@GetMapping("/restapi/student")
	public StudentBean getStudent() throws IOException{
		System.out.println("----------Inside getStudent-------");	
		return new StudentBean("Maha1","Gowda1");
	}
	
	
	//@GetMapping(path="/restapi/student", produces = {MediaType.APPLICATION_XML_VALUE}  )
		@GetMapping(path="/restapi/studentxml", produces=MediaType.APPLICATION_XML_VALUE)
		public StudentBean getStudentXML() throws IOException{
			System.out.println("----------Inside getStudentxml-------");	
			return new StudentBean("Maha1","Gowda1");
		}
	
	@GetMapping("/restapi/students")
	public List<StudentBean> getStudents(){
		List<StudentBean> students = new ArrayList<>();
		students.add(new StudentBean("Maha","Gowda"));
		students.add(new StudentBean("Maha2","Gowda2"));
		students.add(new StudentBean("Maha3","Gowda3"));
		
		System.out.println("----------Inside getStudents-------");	
		return students;
	}
	
	//http://localhost:8080/restapi/student/Maha/Gowda
	//@PathVariable to bind path variable to method variables 
	@GetMapping("/restapi/student/{firstName}/{lastName}")	
	public StudentBean studentPathVariable(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		System.out.println("----------Inside studentPathVariable-------");
		System.out.println("studentQueryParam:firstName" + firstName);
		System.out.println("studentQueryParam:lastName" + lastName);
		return new StudentBean(firstName,lastName);		
		
	}
	
	//Query Parameters (http://localhost:8080/restapi/student?firstName=Maha&lastName=Gowda)
	@GetMapping("/restapi/student/query")
  public StudentBean studentQueryParam(
		  @RequestParam("firstName") String firstName, 
		  @RequestParam("lastName")  String lastName) {
		
		System.out.println("----------Inside studentQueryParam-------");
		System.out.println("studentQueryParam:firstName" + firstName);
		System.out.println("studentQueryParam:lastName" + lastName);
		return new StudentBean(firstName,lastName);
		
	}
}
