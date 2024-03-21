package com.example.swagger.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swagger.entity.Student;
import com.example.swagger.repository.StudentRepository;
import com.example.swagger.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> updateStudent(Long Id, String fullName, String email, Long MobileNumber) {
		Student studentId = studentRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("Student with this " + Id + " is not present"));

		if (fullName != null) {
			studentId.setFullName(fullName);

		}
		if (email != null) {
			studentId.setEmail(email);

		}
		if (MobileNumber != null) {
			studentId.setMobileNumber(MobileNumber);

		}

		studentRepository.save(studentId);
		return Optional.empty();
	}

	@Override
	public Student getById(Long Id) {

		return studentRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("Student with this " + Id + " is not present"));
	}

	@Override
	public List<Student> getall() {

		return studentRepository.findAll();
	}

	@Override
	public void deleteById(Long Id) {
		Student id=studentRepository.findById(Id)
		.orElseThrow(() -> new RuntimeException("Student with this " + Id + " is not present"));
		
		if(id!=null) {
			studentRepository.deleteById(Id);
		}else {
			throw new RuntimeException("Student with this " + Id + " is not present");
		}
	}

}
