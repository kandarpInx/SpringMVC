package com.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Student;
import com.demo.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute Student student) {
        if (student.getStudId() == 0) { 
            studentService.addStudent(student);
        } 
        return "home";
    }
	
	@RequestMapping(value = "/showDetails", method = RequestMethod.POST)
    public ModelAndView listStudent(ModelAndView model) throws IOException {
        List<Student> listStudent = studentService.getAllStudents();
        System.out.println(listStudent.get(0).getStudName());
        model.addObject("listStudent", listStudent);
        model.setViewName("home");
        return model;
    }
	
}
