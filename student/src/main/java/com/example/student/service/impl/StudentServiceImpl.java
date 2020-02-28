package com.example.student.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Service;

import com.example.student.dao.StudentDao;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.example.student.util.HibernateUtil;

/**
 * @author Harry
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private StudentDao studentDao;
	
	public StudentServiceImpl() {
		super();
	}
	
	@Transactional
	public Student saveStudent(Student student) {
		return studentDao.save(student);
	}

	@Transactional
	public Student updateStudent(Student student) {
		return studentDao.saveAndFlush(student);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Student> findBygender(String gender) {
		 List<Student> student = null;
			try {
		         session = HibernateUtil.getSessionFactory().openSession();
		         transaction = session.beginTransaction();
		       
		      // Native query selecting all columns
		         Query query = session.createNativeQuery("SELECT * FROM student_tb where gender like :gender",Student.class)
		        		 .setParameter("gender","%"+gender+"%"); //named parameter binding 
		        
		         student = query.getResultList();
		         transaction.commit(); 
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         if (session != null) {
		            session.close();
		         }
		      }
		     // HibernateUtil.shutdown();
		     return student;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Student> findByStudentname(String studentName) {
		List<Student> student = null;
		try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	       
	      // Native query selecting all columns
	         Query query = session.createNativeQuery("SELECT * FROM student_tb where studentName like :studentName",Student.class)
	        		 .setParameter("studentName","%"+studentName+"%"); //named parameter binding 
	         student = query.getResultList();
	         transaction.commit(); 
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	     // HibernateUtil.shutdown();
	      return student;
	}

	@Transactional
	public Optional<Student> getStudent(Long regno) {
		return studentDao.findById(regno);
	}
}

