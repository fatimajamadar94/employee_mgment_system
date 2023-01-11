package com.yash.ems.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
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
