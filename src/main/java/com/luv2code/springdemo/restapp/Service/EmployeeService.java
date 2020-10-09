package com.luv2code.springdemo.restapp.Service;

import java.util.List;

import com.luv2code.springdemo.restapp.auth.UserAuth;
import com.luv2code.springdemo.restapp.dto.EmployeeDto;
import com.luv2code.springdemo.restapp.model.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EmployeeService extends UserDetailsService {
   List<Employee> findAll();
   void saveAnEmployee(Employee employee);
    Employee findByEmail(String email);
    Employee createEmployee(EmployeeDto employeeDto);
}
