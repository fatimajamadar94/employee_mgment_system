package com.yash.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
