package com.axonactive.jsfdemo.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.axonactive.jsfdemo.employee.EmployeeBOM;
import com.axonactive.jsfdemo.employee.EmployeeEntity;
import com.axonactive.jsfdemo.employee.EmployeeService;

@Path("employee")
public class EmployeeResource {

	@EJB
	EmployeeService employeeService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public EmployeeBOM getOne() {

		EmployeeEntity employeeEntity = employeeService.readOne(1);
		return employeeService.toBom(employeeEntity);
	}

	@GET
	@Path("getall")
	@Produces({ MediaType.APPLICATION_JSON })
	
	public List<EmployeeBOM> getAll() {
		List<EmployeeEntity> employeeEntity = employeeService.readAll();
		return employeeService.toBoms(employeeEntity);
	}

	@GET
	@Path("path/{employeeID}")
	@Produces({ MediaType.APPLICATION_JSON })
	public EmployeeBOM getOnePathParam(@PathParam(value = "employeeID") int employeeID) {

		EmployeeEntity employeeEntity = employeeService.readOne(employeeID);
		return employeeService.toBom(employeeEntity);
	}

	@GET
	@Path("query")
	@Produces({ MediaType.APPLICATION_JSON })
	public EmployeeBOM getOneQueryParam(@QueryParam(value = "employeeID") int employeeID) {
		EmployeeEntity employeeEntity = employeeService.readOne(employeeID);
		return employeeService.toBom(employeeEntity);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addEmployee(EmployeeEntity entity) {

		employeeService.save(entity);
		return Response.status(Response.Status.OK).entity("create thanh cong").build();
	}
	
	@POST
	@Path("update")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateEmployee(EmployeeEntity entity) {
		
		employeeService.update(entity);
		
		return Response.status(Response.Status.OK).entity("update thanh cong").build();
	}
	
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response deleteEmployee(EmployeeEntity entity) {
		
		employeeService.removeEntity(entity);
		return Response.status(Response.Status.OK).entity("delete thanh cong").build();
	}
	
	
	@DELETE
	@Path("deleteID/{employeeID}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response deleteEmployeeByID(@PathParam(value = "employeeID") int id) {
		employeeService.remove(id);
		return Response.status(Response.Status.OK).entity("delete thanh cong").build();

	}
}
