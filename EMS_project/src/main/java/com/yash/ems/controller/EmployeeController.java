package com.yash.ems.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.Employee;
import com.yash.ems.repository.EmployeeRepository;
@RestController
public class EmployeeController {
	 @Autowired
	  EmployeeRepository empRepository;

	  @GetMapping("/getEmployees")
	  public ResponseEntity<List<Employee>> getAllEmployees() {
	    List<Employee> employee = new ArrayList<Employee>();

	      empRepository.findAll().forEach(employee::add);
	   
	    if (employee.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(employee, HttpStatus.OK);
	  }

	  @GetMapping("/employee/{id}")
	  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
	    Optional<Employee> employee = empRepository.findById(id);
	    Employee emp=employee.get();
	       // .orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));

	    return new ResponseEntity<>(emp, HttpStatus.OK);
	  }

	  @PostMapping("/createEmp")
	  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	    Employee employee1 = empRepository.save(employee);
	    return new ResponseEntity<>(employee1, HttpStatus.CREATED);
	  }

	  @PutMapping("/employee/{id}")
	  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
	    Optional<Employee> employee1 = empRepository.findById(id);
	        //.orElseThrow(() -> new ResourceNotFoundException("Not found Employee with id = " + id));

	//    employee.setTiemployee1.getTitle());
	   // employee.setDescription(employee1.getDescription());
	  //  employee.setPublished(employee1.isPublished());
	    
	    return new ResponseEntity<>(empRepository.save(employee), HttpStatus.OK);
	  }

	  @DeleteMapping("/employee/{id}")
	  public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
	    empRepository.deleteById(id);
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

	  @DeleteMapping("/deleteEmployees")
	  public ResponseEntity<HttpStatus> deleteAllEmployees() {
	    empRepository.deleteAll();
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

		/*
		 * @GetMapping("/employees/published") public ResponseEntity<Employee>
		 * findByName() { List<Employee> employee =null; empRepository.findByName(true);
		 * 
		 * if (employee.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 * }
		 * 
		 * return new ResponseEntity<>(employee, HttpStatus.OK); }
		 */

}
