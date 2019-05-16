package com.demo.service;

import java.util.List;

import com.demo.model.Student;

public interface StudentService {
	
	public void addStudent(Student student);
	
	public List<Student> getAllStudents();

}
