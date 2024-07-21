package com.example.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Controller
@RequestScoped
@RolesAllowed("ADMIN")
@Path("users")
public class UsersController {

	@GET
	public String getUsers() {
		return "users.html";
	}

}
