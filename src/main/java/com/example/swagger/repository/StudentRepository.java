package com.example.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swagger.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
