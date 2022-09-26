package com.java.webapp.service;

import java.util.List;

import com.java.webapp.bean.StudentBean;
import com.java.webapp.entity.StudentEntity;



public interface StudentServices {

	
	public String addNewStudent(StudentBean bean);
	public List<StudentBean> listStudent();
	public String deleteStudent(int stdId);
	public StudentBean getStudentByName(String studName);
	
	public StudentBean getStudentById(int studId);
	
	public StudentBean updateStudent(StudentBean bean,int studId);


}
