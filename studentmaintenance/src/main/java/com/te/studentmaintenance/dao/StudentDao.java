package com.te.studentmaintenance.dao;

import com.te.studentmaintenance.bean.StudentBean;

public interface StudentDao {

	public StudentBean getStudent(int id);
	
	public boolean addStudent(StudentBean bean);

	public void searchStudent();

	public boolean deleteStudent(int id);

	public boolean updateStudent(StudentBean bean);
}
