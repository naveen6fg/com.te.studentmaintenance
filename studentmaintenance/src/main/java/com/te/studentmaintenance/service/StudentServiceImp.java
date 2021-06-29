package com.te.studentmaintenance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.studentmaintenance.bean.StudentBean;
import com.te.studentmaintenance.dao.StudentDao;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentDao dao;

	@Override
	public StudentBean getStudent(int id) {
		return dao.getStudent(id);
	}

	@Override
	public boolean addStudent(StudentBean bean) {
		return dao.addStudent(bean);
	}

	@Override
	public void searchStudent() {
		dao.searchStudent();
	}

	@Override
	public boolean deleteStudent(int id) {
		return dao.deleteStudent(id);
	}

	@Override
	public boolean updateStudent(StudentBean bean) {
		return dao.updateStudent(bean);
	}

}
