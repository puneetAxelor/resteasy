package com.axelor.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;

import com.axelor.model.Employee;
import com.axelor.service.Greet;
import com.axelor.service.UserService;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Path("/hello")
public class HelloResource {
	
	@Inject
	private EntityManager em;
	
	@Context
	private HttpRequest request;
	
	@Context
	private HttpResponse response;
	
	@Inject
	private Greet greet;
	

	@Inject
	private UserService userService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	@Path("/ok")
	public void createEmployee(@FormParam("ename") String name, @FormParam("eemail") String email, @FormParam("lid") int lid, @FormParam("lname") String lname) {

        Employee emp = userService.createEmployee(em, name, email, lid, lname);
    
        request.setAttribute("employee", emp);
		
		request.forward("/success.jsp");
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	@Path("/upt")
	public void updateEmployee(@FormParam("eid") int id, @FormParam("ename") String name, @FormParam("eemail") String email, @FormParam("lid") int lid, @FormParam("lname") String lname) {
		
		Employee emp = userService.updateEmployee(em, id, name, email, lid, lname);
    
		request.setAttribute("employee", emp);
		
		request.forward("/success.jsp");
	}
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)

	@Path("/employees")
	public void getEmployees() {
		
		greet.sayHello();
		
		try {
		
			
			List<Employee> list = userService.getEmployees(em);
			
			request.setAttribute("lis", list);
			
			request.forward("/listEmployees.jsp");
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)

	@Path("/employee")
	public void getEmployee(@QueryParam("eid") int id) {
		Employee e = userService.getEmployee(em, id);
		
		request.setAttribute("empl", e);
		
		request.forward("/displayEmployee.jsp");
	}
	
	@GET

	@Transactional
	@Path("/de")
	public void deleteEmployee(@QueryParam("eid") int id) {
		userService.deleteEmployee(em, id);
		System.out.println("In delete");
		request.setAttribute("mes", "user deleted");
		
		request.forward("/deleteEmployee.jsp");
	}
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)

	@Path("/autoupt/{id}")
	public void getAuto(@PathParam("id") int id) {
		Employee e = userService.getEmployee(em, id);
		
		request.setAttribute("empl", e);
		
		request.forward("/update.jsp");
	}
	
	@GET
	@Transactional
	@Path("/dele/{id}")
	public void autoDelete(@PathParam("id") int id) {
		try {	
			userService.deleteEmployee(em, id);
	
			request.setAttribute("mes", "user deleted");
			
			request.forward("/deleteEmployee.jsp");
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}