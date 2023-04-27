package com.cst438.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cst438.domain.Enrollment;
import com.cst438.domain.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import com.cst438.domain.ScheduleDTO;
//
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//
//import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = {"http://localhost:3000"})

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	// delete student 
	@DeleteMapping("/student/{student_id}")
	public void deleteStudent(@PathVariable int student_id) {
//		String student_email = "test@csumb.edu";   // student's email 
//		
//		// TODO  check that today's date is not past deadline to drop course.
//		Enrollment enrollment = enrollmentRepository.findById(enrollment_id).orElse(null);
//		
//		// verify that student is enrolled in the course.
//		if (enrollment!=null && enrollment.getStudent().getEmail().equals(student_email)) {
//			// OK.  drop the course.
//			 enrollmentRepository.delete(enrollment);
//		} else {
//			// something is not right with the enrollment.  
//			throw  new ResponseStatusException( HttpStatus.BAD_REQUEST, "Enrollment_id invalid. "+enrollment_id);
//		}	
		
	}
	
	
 //add new student 
	@PostMapping("/student")
	
//	@RequestParam("name") String name, @RequestParam("email")String email
	@Transactional
	public Student createNewStudent(@RequestParam("name") String name, @RequestParam("email")String email) {
		// need data
		Student student = new Student();
		student.setEmail(email);
		student.setName(name);
		student.setStatusCode(0);
		student.setStudent_id(0);
		
		
		// check if student exists
		// email can not exist all
		if(student.getEmail().equals(email)) {
			// err message
			// student email exists so they cant add the student 
			throw  new ResponseStatusException( HttpStatus.BAD_REQUEST, "Invalid. Student exists.");
		}

		// save to database 
		studentRepository.save(student);
		
		// return student object 
		return student; 
	}
	
	
	
	// update status code
	//update student info
	// i want it to take in the student_id so that it can update the correct students status_code
	// return all student info with correct status code?
	@PutMapping("/student/{status_code}")
	public Student changeStatusCode(@RequestParam("status_code") int status_code ) {
		// change status code 0 or 1
		Student status = new Student();
		status.setStatusCode(status_code);
		return status;
	}
	
	
}
