package com.luv2code.springdemo.restapp.rest;

import java.util.List;

import com.luv2code.springdemo.restapp.ErrorHandling.EmployeeErrorHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springdemo.restapp.Service.EmployeeService;
import com.luv2code.springdemo.restapp.model.Employee;

@RestController
@RequestMapping("management/api/v1")
public class Controller {

	@Autowired
	private EmployeeService employeeService;
	// Injecting values from application.properties
	@Value("${coach.name}")
	public String coachName;
//hasRole('ROLE_'),hasAnyRole('ROLE_').hasAuthority('ROLE_').hasAnyAuthority('ROLE_')

	@GetMapping("/employees")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	@PreAuthorize("hasAuthority('admin:read')")
	public Employee findEmployee(@PathVariable int id){
		Employee employee=employeeService.findById(id);
		if(employee==null){
			throw new EmployeeErrorHandling("EMPLOYEE NOT FOUND");
		}
		return employee;
	}

	@PostMapping("/employees")
	@PreAuthorize("hasAuthority('admin:read')")
	public Employee addEmployee(@RequestBody Employee employee){
		employee.setId(0);
		employeeService.saveAnEmployee(employee);
	return employee;
	}

	@PutMapping("/employees")
	@PreAuthorize("hasAuthority('admin:write')")
	public Employee update(@RequestBody Employee employee){
		employeeService.saveAnEmployee(employee);
		return employee;
	}
	@DeleteMapping("/employees/{id}")
	@PreAuthorize("hasAuthority('admin:read')")
	public String deleteEmployee(@PathVariable int id){
	Employee employee =	employeeService.findById(id);
	if(employee==null){
		throw  new EmployeeErrorHandling("CANNOT DELETE AN INVALID EMPLOYEE");
	}
	employeeService.deleteAnEmployee(id);
return "EMPLOYEE DELETED" +employee.getFirstName() ;
	}

}
