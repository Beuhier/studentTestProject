package com.example.student.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dao.StudentDao;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;
/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	Student student = new Student();
	
	@Autowired
	private StudentService studentService;
	
	@SuppressWarnings("unused")
	@Autowired
	private StudentDao studentDao;
	
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public Student save(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@PutMapping(path= "/update")
	public Student update(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@GetMapping(path="/{regno}", produces = "application/json")
	public Optional<Student> getMember(@PathVariable(name = "regno") Long regno) {
		return studentService.getStudent(regno);
	}
	
	
	@GetMapping(path="name/{studentName}", produces = "application/json")
	public List<Student> getMember(@PathVariable(name = "studentName") String studentName) {	
		return studentService.findByStudentname(studentName);
	}
	
	@GetMapping(path="gender/{gender}", produces ="application/json")
	@ResponseBody
	public List<Student> getStudentByGender(@PathVariable(name = "gender") String gender){
		return studentService.findBygender(gender);
	}
	
}

