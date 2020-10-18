package com.luv2code.springdemo.restapp.rest;

import com.luv2code.springdemo.restapp.dto.EmployeeDto;
import com.luv2code.springdemo.restapp.errorHandling.EmployeeErrorHandling;
import com.luv2code.springdemo.restapp.service.EmployeeService;
import com.luv2code.springdemo.restapp.dto.Util;
import com.luv2code.springdemo.restapp.model.Employee;
import com.luv2code.springdemo.restapp.util.OperationStatusModel;
import com.luv2code.springdemo.restapp.util.RequestOperationName;
import com.luv2code.springdemo.restapp.util.RequestOperationStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ControllerManager {

    @Autowired
    private EmployeeService employeeService;

    // Injecting values from application.properties
    @Value("${coach.name}")
    public String coachName;


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    //
//	@GetMapping("/employees/{id}")
//	public Employee findEmployee(@PathVariable int id){
//		Employee employee=employeeService.findById(id);
//		if(employee==null){
//			throw new EmployeeErrorHandling("EMPLOYEE NOT FOUND");
//		}
//		return employee;
//	}
//
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        ModelMapper modelMapper=new ModelMapper();
        EmployeeDto employeeDto=modelMapper.map(employee,EmployeeDto.class);


        employeeService.createEmployee(employeeDto);
        return employee;
    }

    @PutMapping("/employees/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        employeeService.saveAnEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public OperationStatusModel deleteEmployee(@PathVariable String email) {
        OperationStatusModel operationStatusModel = new OperationStatusModel();
        Employee employee = employeeService.findByEmail(email);
        if (employee == null) {
            throw new EmployeeErrorHandling("CANNOT DELETE AN INVALID EMPLOYEE");
        }
        operationStatusModel.setOperationName(RequestOperationName.DELETE.name());
        operationStatusModel.setOperationResults(RequestOperationStatus.SUCCESS.name());
        employeeService.deleteByEmail(email);
        return operationStatusModel;
    }

    @GetMapping("/employees/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        Employee employee = employeeService.findByEmail(email);
        if (employee == null) {
            throw new EmployeeErrorHandling("EMPLOYEE CAN'T BE FOUND");
        }
        return employeeService.findByEmail(email);

    }


}
