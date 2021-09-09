package com.axelor.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="laptop_table")
//@DiscriminatorValue(value = "laptop_type")
public class Laptop {

	@Id
	private int lid;
	
	private String lname;
	
	@ManyToMany
	private List<Employee> employee = new ArrayList<Employee>();
	
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + ", employee=" + employee + "]";
	}

	
	
	
}
