package com.hmstatus.user.api;

public class AuthRequest {
	
	private String username = "admin";

	private String password = "Admin@june2023";

	public String getUsername() {
		return username;
	}

//	public void setUsername(String username) {
//		this.username = username;
//	}

	public String getPassword() {
		return password;
	}


//	public void setPassword(String password) {
//		this.password = password;
//	}

	public AuthRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}	
	
	public AuthRequest() {
		
	}

}
