package com.yash.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
