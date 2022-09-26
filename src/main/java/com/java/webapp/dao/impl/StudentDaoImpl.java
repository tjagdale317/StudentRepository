package com.java.webapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.java.webapp.bean.StudentBean;
import com.java.webapp.dao.StudentDao;
import com.java.webapp.entity.StudentEntity;
import com.java.webapp.util.HibernateUtil;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	static {
		System.out.println("StudentDaoImpl  Loaded...");
	}

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public String saveStudent(StudentEntity entity) {
		Session session = null;
		Transaction tr = null;
		try
		{
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			
//			Criteria cr = session.createCriteria(StudentEntity.class);
//			cr.add(Restrictions.eq("studEmail",entity.getStudEmail()));
//			if(cr.list().size()>0) {
//				return "Duplicate Student..!";
//			}
//			
			session.save(entity);
			return "Student Record Saved";
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem in Inseration..!");
		}finally {
			HibernateUtil.cleanResources(session, tr);
		}
		return "Inseration Failed";
	}

	
	
	@Override
	public StudentEntity getStudentById(int studId) {

		Session session=null;
		Transaction tr=null;
		try {
			session= sessionFactory.openSession();
			tr=session.beginTransaction();

			StudentEntity info=session.get(StudentEntity.class, studId);
			return info;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanResources(session, tr);
		}
		return null;
	}

	@Override
	public StudentEntity getStudentByName(String studName) {
		/*
		 * Session session=null; Transaction tr=null; try { session=
		 * sessionFactory.openSession(); tr=session.beginTransaction();
		 * 
		 * StudentEntity info=session.get(StudentEntity.class, studName); return info; }
		 * catch (Exception e) { // TODO: handle exception }finally {
		 * HibernateUtil.cleanResources(session, tr); }
		 */
		return null;
	}

	@Override
	public List<StudentEntity> getListOfStudent() {
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			Criteria cr = session.createCriteria(StudentEntity.class);
			List<StudentEntity> entities=cr.list();
			return entities;
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanResources(session, tr);
		}
		return null;
	
	}

	@Override
	public String deleteStudent(int studId) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			StudentEntity entity=session.get(StudentEntity.class, studId);
			session.delete(entity);
			return "student deleted";
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanResources(session, tr);
		}
		return null;
	
	}



	@Override
	public StudentEntity saveUpdatedStudent(StudentEntity entity) {
		Session session=null;
		Transaction tr=null;
		try {
			session= sessionFactory.openSession();
			tr=session.beginTransaction();
			session.update(entity);
			StudentEntity stdentity=session.get(StudentEntity.class, entity.getStudId());
			return stdentity;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			HibernateUtil.cleanResources(session, tr);
		}
		return null;
	}

	

	


	
	}

	
	

