package com.hmstatus.user;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//@Entity
//@Table(name = "USserCredentials")
public class UserCredentials implements UserDetails{
	
//	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id; 
//
//	@Column(nullable = false, unique = true, length = 50)
//	private String username;
//
//	@Column(nullable = false, length = 64)
//	private String password;
	
	private String username = "admin";

	private String password = "Admin@june2023";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}


//	public void setPassword(String password) {
//		this.password = password;
//	}

	public UserCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}	
	
	public UserCredentials() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
