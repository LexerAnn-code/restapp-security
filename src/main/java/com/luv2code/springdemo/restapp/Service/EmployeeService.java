package com.luv2code.springdemo.restapp.Service;

import java.util.List;

import com.luv2code.springdemo.restapp.model.Employee;

public interface EmployeeService {
public List<Employee> findAll();
    public void saveAnEmployee(Employee employee);
    public void deleteAnEmployee(int id );
    public Employee findById(int id);
}
