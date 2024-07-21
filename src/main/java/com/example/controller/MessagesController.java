package com.example.controller;

import java.sql.SQLException;
import com.example.model.MessageDAO;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Controller
@RequestScoped
@RolesAllowed("USER")
@Path("messages")
public class MessagesController {
	@Inject
	private Models models;
	@Inject
	private MessageDAO messagesDAO;
	@Inject
	private HttpServletRequest req;

	@GET
	public String getMessages() throws SQLException {
		models.put("userName", req.getRemoteUser());
		models.put("isAdmin", req.isUserInRole("ADMIN"));
		models.put("messages", messagesDAO.getAll());
		return "messages.html";
	}

	@POST
	public String postMessages(@FormParam("message") String mes) throws SQLException {
		messagesDAO.create(req.getRemoteUser(), mes);
		return "redirect:/messages/";
	}

	@POST
	@RolesAllowed("ADMIN")
	@Path("clear")
	public String clearMessages() throws SQLException {
		messagesDAO.deleteAll();
		return "redirect:/messages/";
	}

	@GET
	@Path("logout")
	public String logout() {
		try {
			req.logout();
			req.getSession().invalidate();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

}
