package com.luv2code.springdemo.restapp.dao;

import com.luv2code.springdemo.restapp.dto.EmployeeDto;
import com.luv2code.springdemo.restapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
Employee findByEmail(java.lang.String email);
Employee deleteByEmail(String email);
}
