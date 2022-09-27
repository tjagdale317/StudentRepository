package com.java.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.webapp.bean.StudentBean;
import com.java.webapp.entity.StudentEntity;
import com.java.webapp.service.StudentServices;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServices stdservice;

	@PostMapping("/")
	public String saveProductInfo(@RequestBody StudentBean stdBean) {
		System.out.println(stdBean);
		stdservice.addNewStudent(stdBean);
		return "Student Save Successfully..";
	}

	@GetMapping("/{studId}")
	public StudentBean searchStudentById(@PathVariable("studId") int studId) {
		StudentBean bean = stdservice.getStudentById(studId);
		System.out.println("Student by Id----" + bean);
		return bean;
	}
	
	/*
	 * @GetMapping("/byname/{studName}") public StudentBean
	 * searchStudentByName(@PathVariable("studName") String studName) { StudentBean
	 * bean=stdservice.getStudentByName(studName);
	 * System.out.println("stude by name"+bean); return bean; }
	 */

	@GetMapping("/list")
	public List<StudentBean> listofStudent() {

		List<StudentBean> bean = stdservice.listStudent();
		System.out.println("stud by id----" + bean);
		return bean;
	}

	@DeleteMapping("/{studId}")

	public ResponseEntity deleteStudent(@PathVariable("studId") int studId) {
		stdservice.deleteStudent(studId);

		
		return new ResponseEntity("Student deleted successfully",HttpStatus.OK);

	}
	
	@PutMapping("/{studId}")
	public ResponseEntity updateStudentById(@RequestBody StudentBean bean, @PathVariable("studId") int studId) {
		System.out.println("stud by id----"+bean);
		StudentBean studentBean=stdservice.updateStudent(bean,studId);//get student from id for comparison
		if(studId==bean.getStudId()) {
//		String updateBean=studentServie.saveUpdatedStudent(bean);  
		System.out.println(studentBean);
		return new ResponseEntity(studentBean,HttpStatus.OK);
		}		
		return new ResponseEntity("No student found of given id...",HttpStatus.OK);

	}
	
//	@PostMapping("/create-student-profile")
//	public void createStudentProfile(@RequestBody )
//	{
//		
//	}

}
