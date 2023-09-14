package com.jspiders.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.pojo.StudentPOJO;
import com.jspiders.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public StudentPOJO addStudent(StudentPOJO pojo) {
		
		StudentPOJO Student = repository.save(pojo);
		return Student;
	   
	}

}
