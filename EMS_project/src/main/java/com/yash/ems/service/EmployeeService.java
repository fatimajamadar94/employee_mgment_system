package com.yash.ems.service;

import java.util.List;

import com.yash.ems.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);
	


}
