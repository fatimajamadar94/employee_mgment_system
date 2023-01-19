package com.yash.ems.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yash.ems.exception.ResourceNotFoundException;
import com.yash.ems.model.Employee;
import com.yash.ems.repository.EmployeeRepository;
import com.yash.ems.service.EmployeeService;
@RestController
@RequestMapping("/employee/api")
public class EmployeeController {
	 @Autowired
	  EmployeeRepository empRepository;
	 
	 @Autowired
	 EmployeeService service;
	 
		Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	 @GetMapping("/hello")
	 public String get() {
		 return "hello ";
	 }

	  @GetMapping("/getEmployees")
	  public ResponseEntity<List<Employee>> getAllEmployees() {
	    List<Employee> employee = new ArrayList<Employee>();
System.out.println(employee);
	      empRepository.findAll().forEach(employee::add);
	   
	    if (employee.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    else
	    return new ResponseEntity<>(employee, HttpStatus.OK);
	  }

	  @GetMapping("/employee/{id}")
	  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
	    Employee employee = empRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));
		logger.info("employee with Id :" + id + "is" + employee.getId());

	    return new ResponseEntity<>(employee, HttpStatus.OK);
	  }

	  @PostMapping("/createEmp")
	  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	    Employee employee1 = empRepository.save(employee);
	    return new ResponseEntity<>(employee1, HttpStatus.CREATED);
	  }

	  @PutMapping("/employee/{id}")
	  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
	    Employee employee1 = empRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));
	    employee1.setDatOfJoining(employee.getDatOfJoining());
	    employee1.setEmployeeName(employee.getEmployeeName());
	    employee1.setDatOfJoining(employee.getDatOfJoining());
	    employee1.setEmployeeID(employee.getEmployeeID());
	    return new ResponseEntity<>(empRepository.save(employee1), HttpStatus.OK);
	  }

	  @DeleteMapping("/employee/{id}")
	  public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
	    empRepository.deleteById(id);
	    logger.info("employee deleted sucessfully!!");
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

	  @DeleteMapping("/deleteEmployees")
	  public ResponseEntity<HttpStatus> deleteAllEmployees() {
	    empRepository.deleteAll();
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

		
		  @GetMapping("/employees/{keyword}") public ResponseEntity<List<Employee>>
		  searchEmp(@PathVariable("keyword")String keyword) {
			  List<Employee> employee = empRepository.searchEmp(keyword);
		  
		  if (employee.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  else
		  return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		  }
		 
		  //sort all employe as per order 
		  @GetMapping("/sortEmployee")
		    public ResponseEntity<List<Employee>> getAllEmployees(
		                        @RequestParam(defaultValue = "0") Integer pageNo,
		                        @RequestParam(defaultValue = "10") Integer pageSize,
		                        @RequestParam(defaultValue = "id") String sortBy)
		    {
		        List<Employee> list = service.getAllEmployees(pageNo, pageSize, sortBy);

		        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		    }
}
