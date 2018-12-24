package sampledbwebapp;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sampledbwebapp.services.UserService;
import sampledbwebapp.tos.UserTO;

@Path("/users")
public class UserResource {
	
	private UserService userService;

	public UserResource() {
		userService = new UserService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserTO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserTO createUser(UserTO userTO) {
		return userService.createUser(userTO);
	}
}
