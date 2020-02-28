package com.example.student.dao;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;


/**
* @author Harry
*
*/
@Repository
public interface StudentDao extends JpaRepository<Student, Long>{
	List<Student> findByGender(String gender);
}
