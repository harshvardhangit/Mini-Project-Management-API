package com.example.projectmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequest {

	@NotBlank(message = "Name cannot be blank")
	@NotNull(message = "Name cannot be null")
	private String username;
	
	@NotBlank(message = "password cannot be blank")
	@NotNull(message = "password cannot be null")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
