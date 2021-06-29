package com.te.studentmaintenance.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
@JsonPropertyOrder({"userId", "emailId","marks", "name", "grade" })
public class StudentBean implements Serializable {

	@Id
	@Column
	@JsonProperty("user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column
	private String emailId;
	@Column
	private double marks;
	@Column
	private String name;
	@Column
	private String grade;
	
	
}

