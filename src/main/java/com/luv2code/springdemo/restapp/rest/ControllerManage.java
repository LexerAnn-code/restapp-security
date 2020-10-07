package com.luv2code.springdemo.restapp.rest;

import com.luv2code.springdemo.restapp.ErrorHandling.EmployeeErrorHandling;
import com.luv2code.springdemo.restapp.Service.EmployeeService;
import com.luv2code.springdemo.restapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ControllerManage {

	@Autowired
	private EmployeeService employeeService;
	// Injecting values from application.properties
	@Value("${coach.name}")
	public String coachName;


	@GetMapping()
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee findEmployee(@PathVariable int id){
		Employee employee=employeeService.findById(id);
		if(employee==null){
			throw new EmployeeErrorHandling("EMPLOYEE NOT FOUND");
		}
		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee){
		employee.setId(0);
		employeeService.saveAnEmployee(employee);
	return employee;
	}

	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee){
		employeeService.saveAnEmployee(employee);
		return employee;
	}
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id){
	Employee employee =	employeeService.findById(id);
	if(employee==null){
		throw  new EmployeeErrorHandling("CANNOT DELETE AN INVALID EMPLOYEE");
	}
	employeeService.deleteAnEmployee(id);
return "EMPLOYEE DELETED" +employee.getFirstName() ;
	}

}
