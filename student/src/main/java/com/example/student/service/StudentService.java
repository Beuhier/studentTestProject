package com.example.student.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.student.entity.Student;

@Service
public interface StudentService {

	Student saveStudent(Student student);
	
	Student updateStudent(Student student);
	
	List<Student> findBygender(String gender);
	
	List<Student> findByStudentname(String studentName);
	
	Optional<Student> getStudent(Long regno);

}