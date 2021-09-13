package com.axelor.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.query.Query;

import com.axelor.model.Employee;
import com.axelor.model.Laptop;

public class UserServiceImpl implements UserService {
	

	public Employee createEmployee(EntityManager em, String name, String email, int lid, String lname) {
	        

		
		Laptop laptop = new Laptop();
		laptop.setLid(lid);
		laptop.setLname(lname);
		
			 Employee employee = new Employee();
			 employee.setName(name);
			 employee.setEmail(email);
			 
			 employee.getLaptop().add(laptop);
				
			 laptop.getEmployee().add(employee); 
			
			 em.persist(laptop);
			 em.persist(employee);
		    
	        return employee;
	    }
	
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(EntityManager em) {
		
		@SuppressWarnings("unchecked")
		Query<Employee> query = (Query<Employee>) em.createQuery("Select e1 FROM Employee e1 ");
		return query.getResultList();
	}

	@Override
	public Employee updateEmployee(EntityManager em, int id, String name, String email, int lid, String lname) {
		
		Employee employee = em.find(Employee.class, id);
		employee.setName(name);
		employee.setEmail(email);
		
		Laptop laptop = em.find(Laptop.class, lid);
		laptop.setLid(lid);
		laptop.setLname(lname);

		employee.getLaptop().add(laptop);
		

		em.merge(employee);
		
		return employee;
	}

	@Override
	public Employee getEmployee(EntityManager em, int id) {
		Employee e = em.find(Employee.class, id);
		return e;
	}

	@Override
	public void deleteEmployee(EntityManager em, int id) {
		Employee e = em.find(Employee.class, id);
	 em.remove(e);
		
	}
	
}
