package com.demo.dao;

import java.util.List;

import com.demo.model.Student;

public interface StudentDAO {
	
	public void addStudent(Student student);
	
	public List<Student> getAllStudents();

}
