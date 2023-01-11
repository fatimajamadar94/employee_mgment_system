package com.yash.ems.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@javax.persistence.Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String employeeName;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date datOfJoining;
	private Double totalExperience;
	private String reportingManager;
	private String role;
	private Long EmployeeID;
	

}
