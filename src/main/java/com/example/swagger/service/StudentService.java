package com.example.swagger.service;

import java.util.List;
import java.util.Optional;

import com.example.swagger.entity.Student;

public interface StudentService {
	public Student save(Student student);

	Optional<Student> updateStudent(Long Id, String fullName, String email, Long MobileNumber);

	public Student getById(Long Id);

	public List<Student> getall();

	public void deleteById(Long Id);
}
