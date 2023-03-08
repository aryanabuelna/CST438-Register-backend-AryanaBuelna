package com.cst438.controller;

import org.springframework.web.bind.annotation.RestController;

//import com.cst438.domain.ScheduleDTO;
//
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.cst438.domain.Student;
//import com.cst438.domain.StudentRepository;

@RestController
public class StudentController {
	
//	@GetMapping("/student")
//	public Student getStudent(@RequestParam("student_id") int student_id) {
//		return "student id = 12398";
//	}
//	
	// change student status_code
//	@PostMapping("/student")
//	public int changeStudentRecord(@RequestParam("student_id") int student_id) {
//
//		String student_email = "test@csumb.edu";   // student's email 
//		
//		Student student = studentRepository.findByEmail(student_email);
//		int s_id = student.getStudent_id(); 
//		return s_id;
//	}
	
 //add student 
	@PostMapping("/student")
	public String createNewStudent() {
		return "student id = 12398"; 
	}
}
