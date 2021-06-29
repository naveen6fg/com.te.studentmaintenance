package com.te.studentmaintenance.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("employee_response")
@JsonPropertyOrder({ "statusCode", "msg" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse implements Serializable{

	private int statusCode;

	private String msg;

	private String description;

	@JsonProperty("Student_info")
	private StudentBean bean;

	@JsonProperty("Student_details")
	private List<StudentBean> studentBeans;
}
