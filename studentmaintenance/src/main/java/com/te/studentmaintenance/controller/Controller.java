package com.te.studentmaintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.studentmaintenance.bean.StudentBean;
import com.te.studentmaintenance.bean.StudentResponse;
import com.te.studentmaintenance.service.StudentService;

@RestController
public class Controller {

	@Autowired
	StudentService service;

	@GetMapping(path = "/getData", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponse getData(int id) {
		StudentResponse response = new StudentResponse();
		StudentBean studentBean = service.getStudent(id);
		if (studentBean != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Student details found for :" + id);
			response.setBean(studentBean);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}

	@PostMapping(path = "/addEmp", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse addEmp(@RequestBody StudentBean bean) {
		StudentResponse response = new StudentResponse();
		boolean beans = service.addStudent(bean);
		if (beans != false) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Student Data Added");
			response.setBean(bean);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not Added");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteEmp/{user_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponse deleteEmp(@PathVariable(name = "user_id") int id) {
		StudentResponse response = new StudentResponse();
		boolean StudentBean = service.deleteStudent(id);
		if (StudentBean != false) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Delete Student details found for :" + id);
			//response.setBean(StudentBean);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}
	
	@PutMapping(path = "/update")
	public StudentResponse Update(@RequestBody StudentBean bean) {
		StudentResponse response = new StudentResponse();
		boolean beans = service.updateStudent(bean);
		if (beans != false) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee Data Updated");
			// response.setBean(employeeBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not Updated");
		}
		return response;
	}

}
