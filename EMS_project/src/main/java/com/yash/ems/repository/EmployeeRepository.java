package com.yash.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.ems.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value="SELECT p FROM Employee p WHERE " +
            "p.employeeName LIKE CONCAT('%',:keyword, '%')" +
            "Or p.reportingManager LIKE CONCAT('%', :keyword, '%')",nativeQuery=false)
List<Employee> searchEmp(String keyword);

}
