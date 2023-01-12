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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getDatOfJoining() {
		return datOfJoining;
	}
	public void setDatOfJoining(Date datOfJoining) {
		this.datOfJoining = datOfJoining;
	}
	public Double getTotalExperience() {
		return totalExperience;
	}
	public void setTotalExperience(Double totalExperience) {
		this.totalExperience = totalExperience;
	}
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", datOfJoining=" + datOfJoining
				+ ", totalExperience=" + totalExperience + ", reportingManager=" + reportingManager + ", role=" + role
				+ ", EmployeeID=" + EmployeeID + "]";
	}
	

}
