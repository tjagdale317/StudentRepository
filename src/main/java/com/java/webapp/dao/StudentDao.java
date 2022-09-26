package com.java.webapp.dao;

import java.util.List;

import com.java.webapp.bean.StudentBean;
import com.java.webapp.entity.StudentEntity;

public interface StudentDao {
	
	
	public String saveStudent(StudentEntity entity);
	public List<StudentEntity> getListOfStudent();
	public String deleteStudent(int studId);
	public StudentEntity getStudentByName(String studName);
	public StudentEntity saveUpdatedStudent(StudentEntity entity);
	public StudentEntity getStudentById(int studId);
	

}
