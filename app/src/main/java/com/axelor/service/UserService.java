package com.axelor.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.axelor.model.Employee;

public interface UserService {

	public Employee createEmployee(EntityManager em, String name, String email, int lid, String lname);
	
	public Employee getEmployee(EntityManager em, int id);
	
	public List<Employee> getEmployees(EntityManager em);
	
	public Employee updateEmployee(EntityManager em, int id, String name, String email, int lid, String lname);
	
	public void deleteEmployee(EntityManager em, int id);
}
