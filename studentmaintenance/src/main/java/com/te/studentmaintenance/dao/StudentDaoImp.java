package com.te.studentmaintenance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.studentmaintenance.bean.StudentBean;

@Repository
public class StudentDaoImp implements StudentDao {

//	@PersistenceUnits
//	private EntityManagerFactory factory;

	@Override
	public StudentBean getStudent(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager entityManager = factory.createEntityManager();

		StudentBean studentBean = entityManager.find(StudentBean.class, id);
		return studentBean;

	}

	@Override
	public boolean addStudent(StudentBean bean) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			entityManager.persist(bean);
			if (bean != null) {
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			transaction.rollback();
			isAdded = false;
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public void searchStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteStudent(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			StudentBean bean = entityManager.find(StudentBean.class, id);
			if (bean != null) {
				entityManager.remove(bean);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean updateStudent(StudentBean bean) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isUpdated = false;

		try {
			transaction.begin();
			StudentBean info = manager.find(StudentBean.class, bean.getUserId());
			if (bean.getName() != null && bean.getName() != "") {
				info.setName(bean.getName());
			}
			if (bean.getName() != null) {
				info.setName(bean.getName());
			}

			if (bean.getEmailId() != null && bean.getEmailId() != "") {
				info.setEmailId(bean.getEmailId());
			}

			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return isUpdated;
	}

}
