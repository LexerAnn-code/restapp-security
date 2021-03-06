package com.luv2code.springdemo.restapp.emploeeServiceImpl;

import java.util.List;

import com.luv2code.springdemo.restapp.dao.EmployeeRepository;
import com.luv2code.springdemo.restapp.dto.EmployeeDto;
import com.luv2code.springdemo.restapp.dto.Util;
import com.luv2code.springdemo.restapp.errorHandling.EmployeeErrorHandling;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.restapp.service.EmployeeService;
import com.luv2code.springdemo.restapp.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	@Autowired
	Util util;
	@Autowired
private 	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	//	return employeeDAO.findAll();
	}

	@Override

	public void saveAnEmployee(Employee employee) {

		String publicKey = util.generateUserId(5);
		employee.setId(publicKey);
		employeeRepository.save(employee);
		//employeeDAO.saveAnEmployee(employee);
	}

	@Override
	public Employee findByEmail(String email) {
	return 	employeeRepository.findByEmail(email);

	}

	@Override
	public Employee deleteByEmail(String email) {
		return employeeRepository.deleteByEmail(email);
	}

//	@Override
//	public Employee updateByEmail(String email) {
//		return  employeeRepository.save();
//	}



	@Override
	public Employee createEmployee(EmployeeDto employeeDto) {
		ModelMapper modelMapper=new ModelMapper();
		Employee employee=modelMapper.map(employeeDto,Employee.class);

		Employee storedEmail=employeeRepository.findByEmail(employeeDto.getEmail());
		if(storedEmail!=null) throw new EmployeeErrorHandling("EMAIL EXISTS");


		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return null;
	}

//	@Override
//	public void deleteAnEmployee(int id) {
//	//	employeeDAO.deleteAnEmployee(id);
//		Optional<Employee> results = employeeRepository.findById(id);
//		Employee employee=null;
//		if(results.isPresent()){
//			employeeRepository.deleteById(id);
//		}
//		else {
//			throw new EmployeeErrorHandling("CANT DELETE AN EMPLOYEE THAT DOESN'T EXISTS");
//		}
//
//	}
//
//	@Override
//
//	public Employee findById(int id) {
//	//	return employeeDAO.findById(id);
//		Optional<Employee> results = employeeRepository.findById(id);
//		Employee employee=null;
//		if(results.isPresent()){
//			employee=results.get();
//		}
//		else {
//			throw new EmployeeErrorHandling("EMPLOYEE NOT FOUND");
//		}
//		return employee;
//	}
//
//	@Override
//	public Employee findbyUserId(String id) {
//		employeeRepository.findByUserId(id)
//		return null;
//	}
//
//	@Override
//	public Employee findbyEmail(String email) {
//		return null;
//	}
//
//	@Override
//	public Employee findbyString(String id) {
//		UserDto returnValue=new UserDto();
//		employeeRepository.findByUserId(id)
//		return null;
//	}
//
//	@Override
//	public Employee findbyString(int id) {
//		employeeRepository.findById(id);
//		return null;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Employee userEmpoyee=employeeRepository.findByEmail
//		return null;
//	}
}
