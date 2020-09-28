package com.luv2code.springdemo.restapp.EmployeeDAOImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.security.sasl.SaslServer;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.luv2code.springdemo.restapp.model.Employee;
import com.luv2code.springdemo.restapp.dao.EmployeeDAO;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	

	public EmployeeDAOImp() {
	}



	@Override
	public List<Employee> findAll() {
		Session currentSeason = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSeason.createQuery("from Employee", Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public void saveAnEmployee(Employee employee) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}


	@Override
	public void deleteAnEmployee(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query theEmployee=currentSession.createQuery("delete from Employee where id=:employeeID");
		theEmployee.setParameter("employeeID",id);
		theEmployee.executeUpdate();


	}

	@Override
	public Employee findById(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee theEmployee=currentSession.get(Employee.class,id);
		return  theEmployee;
	}


}
