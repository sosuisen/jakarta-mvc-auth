package com.example.model;

import jakarta.ws.rs.FormParam;

public class MessageDTO {
	@FormParam("id")
	private int id;
	@FormParam("name")
	private String name;
	@FormParam("message")
	private String message;

	public MessageDTO() {
	}

	public MessageDTO(int id, String name, String message) {
		this.id = id;
		this.name = name;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}