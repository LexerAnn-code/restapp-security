package com.luv2code.springdemo.restapp.EmploeeServiceImpl;

import java.util.List;
import java.util.Optional;

import com.luv2code.springdemo.restapp.ErrorHandling.EmployeeError;
import com.luv2code.springdemo.restapp.ErrorHandling.EmployeeErrorHandling;
import com.luv2code.springdemo.restapp.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.restapp.Service.EmployeeService;
import com.luv2code.springdemo.restapp.dao.EmployeeDAO;
import com.luv2code.springdemo.restapp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	public EmployeeDAO employeeDAO;

	@Autowired
private 	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	//	return employeeDAO.findAll();
	}

	@Override

	public void saveAnEmployee(Employee employee) {
		employeeRepository.save(employee);
		//employeeDAO.saveAnEmployee(employee);
	}

	@Override

	public void deleteAnEmployee(int id) {
	//	employeeDAO.deleteAnEmployee(id);
		Optional<Employee> results = employeeRepository.findById(id);
		Employee employee=null;
		if(results.isPresent()){
			employeeRepository.deleteById(id);
		}
		else {
			throw new EmployeeErrorHandling("CANT DELETE AN EMPLOYEE THAT DOESN'T EXISTS");
		}

	}

	@Override

	public Employee findById(int id) {
	//	return employeeDAO.findById(id);
		Optional<Employee> results = employeeRepository.findById(id);
		Employee employee=null;
		if(results.isPresent()){
			employee=results.get();
		}
		else {
			throw new EmployeeErrorHandling("EMPLOYEE NOT FOUND");
		}
		return employee;
	}

}
