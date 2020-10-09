package com.luv2code.springdemo.restapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "Employee")
//@SequenceGenerator(name = "sequence",sequenceName = "Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = -699973489826357998L;
	@Id
private String id;
@Column(name = "first_name")
private String firstName;
@Column(name = "last_name")
private String lastName;
@Column(name = "email")
private String email;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Employee(String id, String firstName, String lastName, String email) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
}
public Employee() {
}
}
