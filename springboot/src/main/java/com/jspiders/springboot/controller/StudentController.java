package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jspiders.springboot.pojo.StudentPOJO;
import com.jspiders.springboot.response.StudentResponse;
import com.jspiders.springboot.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/add")
	private ResponseEntity<StudentResponse> 
	                                    addStudent(@RequestBody StudentPOJO pojo){
		
        StudentPOJO student= service.addStudent(pojo);
        
        if (student !=null) {
			return new ResponseEntity<>(new StudentResponse("insereted", student, null),HttpStatus.ACCEPTED);
		}
        return new ResponseEntity<StudentResponse>
		                                (new StudentResponse("Student data not inserted. ",null, null),
				                                                                       	HttpStatus.NOT_ACCEPTABLE);		
	}
}
