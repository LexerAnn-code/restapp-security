package com.luv2code.springdemo.restapp.dao;

import com.luv2code.springdemo.restapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
