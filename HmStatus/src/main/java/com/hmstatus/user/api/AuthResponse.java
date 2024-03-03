package com.hmstatus.user.api;

public class AuthResponse {

	private String username;

	private String accessToken;

	public String getUsername() {
		return username;
	}

//	public void setUsername(String username) {
//		this.username = username;
//	}

	public String getAccessToken() {
		return accessToken;
	}


//	public void setPassword(String password) {
//		this.password = password;
//	}

	public AuthResponse(String username, String accessToken) {
		this.username = username;
		this.accessToken = accessToken;
	}	
	
	public AuthResponse() {
		
	}
}
