package com.axelor.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;

import com.axelor.factory.UserServiceFactory;
import com.axelor.model.Employee;
import com.axelor.service.Greet;
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
	
//	private static UserService userService = new UserServiceImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@Path("/ok")
	public void createEmployee(@FormParam("ename") String name, @FormParam("eemail") String email, @FormParam("lid") int lid, @FormParam("lname") String lname) {

        Employee emp = UserServiceFactory.getUserService().createEmployee(em, name, email, lid, lname);
    
        request.setAttribute("employee", emp);
		
		request.forward("/success.jsp");
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	@Path("/upt")
	public void updateEmployee(@FormParam("eid") int id, @FormParam("ename") String name, @FormParam("eemail") String email, @FormParam("lid") int lid, @FormParam("lname") String lname) {
		
		Employee emp = UserServiceFactory.getUserService().updateEmployee(em, id, name, email, lid, lname);
    
		request.setAttribute("employee", emp);
		
		request.forward("/success.jsp");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
//	@Transactional
	@Path("/employees")
	public void getEmployees() {
		
		greet.sayHello();
		
		try {
		
			
			List<Employee> list = UserServiceFactory.getUserService().getEmployees(em);
			
			request.setAttribute("lis", list);
			
			request.forward("/listEmployees.jsp");
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
//	@Transactional
	@Path("/employee")
	public void getEmployee(@QueryParam("eid") int id) {
		Employee e = UserServiceFactory.getUserService().getEmployee(em, id);
		
		request.setAttribute("empl", e);
		
		request.forward("/displayEmployee.jsp");
	}
	
	@GET
//	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	@Path("/de")
	public void deleteEmployee(@QueryParam("eid") int id) {
		UserServiceFactory.getUserService().deleteEmployee(em, id);
		System.out.println("In delete");
		request.setAttribute("mes", "user deleted");
		
		request.forward("/deleteEmployee.jsp");
	}
}