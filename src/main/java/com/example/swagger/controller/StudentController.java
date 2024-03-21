package com.example.swagger.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.entity.Student;
import com.example.swagger.service.StudentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name="auth")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
	}

	@PutMapping("/update/{id}")
	public Optional<Student> updateStudentDetails(@PathVariable Long id,
			@RequestParam(required = false) String fullName, @RequestParam(required = false) String email,
			@RequestParam(required = false) Long MobileNumber) {

		return studentService.updateStudent(id, fullName, email, MobileNumber);
	}

	@GetMapping("/getById/{Id}")
	public Student getById(@PathVariable Long Id) {
		return studentService.getById(Id);

	}

	@GetMapping("/getall")
	public List<Student> getallstudentDetails() {
		return studentService.getall();

	}

	@DeleteMapping("/deletedByID/{Id}")
	public void deleteById(@PathVariable Long Id) {
		studentService.deleteById(Id);
	}

}
