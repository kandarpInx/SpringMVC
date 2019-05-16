package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Transactional
	public void addStudent(Student student) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
 
	@Transactional
	public List<Student> getAllStudents() {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<Student> student = session.createQuery("from Student").list();
		session.getTransaction().commit();
		session.close();
		return student;
	}
}
