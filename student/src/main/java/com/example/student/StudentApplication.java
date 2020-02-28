

package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.student.service.StudentService;
import com.example.student.service.impl.StudentServiceImpl;



@SpringBootApplication
public class StudentApplication extends SpringBootServletInitializer {

	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(StudentApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
