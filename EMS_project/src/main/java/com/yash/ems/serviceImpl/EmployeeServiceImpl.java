package com.yash.ems.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yash.ems.model.Employee;
import com.yash.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements  com.yash.ems.service.EmployeeService {
	@Autowired
	EmployeeRepository repository;
	  public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
	    {
	        Pageable paging = (Pageable) PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

	        Page<Employee> pagedResult = repository.findAll(paging);

	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Employee>();
	        }
	    }
}
