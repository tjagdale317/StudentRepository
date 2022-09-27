package com.java.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.webapp.bean.StudentBean;
import com.java.webapp.dao.StudentDao;
import com.java.webapp.entity.StudentEntity;
import com.java.webapp.service.StudentServices;

@Service
public class StudentServiceImpl implements StudentServices {

	static {
		System.out.println("Student service imp loaded");
	}

	@Autowired
	StudentDao stdDao;

	public StudentEntity beanToEntity(StudentBean stdBean) {
		StudentEntity studentity = new StudentEntity();
		studentity.setStudId(stdBean.getStudId());
		studentity.setStudName(stdBean.getStudName());
		studentity.setStudEmail(stdBean.getStudEmail());
		studentity.setStudFees(stdBean.getStudFees());
		studentity.setStudGender(stdBean.getStudGender());
		studentity.setStudAddress(stdBean.getStudAddress());
		return studentity;
	}

	@Override
	public String addNewStudent(StudentBean bean) {

		return stdDao.saveStudent(beanToEntity(bean));
	}

	public StudentBean studEntityToBean(StudentEntity entity) {
		StudentBean bean = new StudentBean();
		bean.setStudId(entity.getStudId());
		bean.setStudName(entity.getStudName());
		bean.setStudEmail(entity.getStudEmail());
		bean.setStudFees(entity.getStudFees());
		bean.setStudGender(entity.getStudGender());
		bean.setStudAddress(entity.getStudAddress());
		return bean;
	}

	@Override
	public StudentBean getStudentById(int studId) {
		StudentEntity entity = stdDao.getStudentById(studId);
		return studEntityToBean(entity);
	}

	@Override
	public StudentBean getStudentByName(String studName) {
		// StudentEntity entity = stdDao.getStudentByName(studName);
		// return studEntityToBean(entity);
		return null;
	}

	@Override
	public List<StudentBean> listStudent() {
		List<StudentEntity> entities = stdDao.getListOfStudent();

		List<StudentBean> beans = convertEntitiesToBeans(entities);
		return beans;

	}

	private List<StudentBean> convertEntitiesToBeans(List<StudentEntity> entities) {
		List<StudentBean> list = new ArrayList<StudentBean>();
		for (StudentEntity std : entities) {
			StudentBean bean = studEntityToBean(std);
			bean.setStudId(std.getStudId());
			bean.setStudName(std.getStudName());
			bean.setStudEmail(std.getStudEmail());
			bean.setStudFees(std.getStudFees());
			bean.setStudGender(std.getStudGender());
			bean.setStudAddress(std.getStudAddress());
			list.add(bean);
		}
		return list;
	}

	@Override
	public String deleteStudent(int stdId) {

		return stdDao.deleteStudent(stdId);
	}

	@Override
	public StudentBean updateStudent(StudentBean bean, int studId) {
		List<StudentEntity> studList = stdDao.getListOfStudent();
		
		
		System.out.println("list-----" + studList);
		for (StudentEntity entity : studList) {
			if (entity.getStudId() == studId) {

				entity.setStudId(bean.getStudId());
				entity.setStudName(bean.getStudName());
				entity.setStudEmail(bean.getStudEmail());
				entity.setStudFees(bean.getStudFees());
				entity.setStudGender(bean.getStudGender());
				entity.setStudAddress(bean.getStudAddress());

				return studEntityToBean(stdDao.saveUpdatedStudent(entity));

			}
		}
		return bean;
	}

}
