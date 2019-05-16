package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDAO;
import com.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDao;
	
	
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

}
