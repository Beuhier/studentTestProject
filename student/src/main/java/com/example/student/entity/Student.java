package com.example.student.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="student_tb")
@Data

@SqlResultSetMapping(
		name = "StudentMapping",
	classes = @ConstructorResult(
	    targetClass = Student.class,
	    columns = {
	        @ColumnResult(name = "regno", type = Long.class),
	        @ColumnResult(name = "studentName"),
	        @ColumnResult(name = "gender")
		}))
public class Student implements Serializable {
	
	public Student() {}
	
	 private static final long serialVersionUID = 1L;
	 
	 @Id
	 @Column(name="regno")
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long regno;
	 
	 @Column(name="studentName")
	 private String studentName;
	 
	 @Column(name="gender")
	 private String gender;


	public Student(Long regno, String studentName, String gender) {
		this.regno = regno;
		this.studentName = studentName;
		this.gender = gender;
    }
	
}





