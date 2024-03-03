package com.hmstatus.user.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmstatus.jwt.JwtTokenUtil;
import com.hmstatus.user.UserCredentials;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class AuthApi {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenUtil jwtTokenUtil; 
	
	UserCredentials userCredentials = new UserCredentials();

	@PostMapping("/token")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			if (request.getUsername().equals(userCredentials.getUsername())
					&& request.getPassword().equals(userCredentials.getPassword())) {

				String accessToken = jwtTokenUtil.generateAccessToken(userCredentials);
				AuthResponse authResponse = new AuthResponse(request.getUsername(), accessToken);

				return ResponseEntity.ok(authResponse);
			}

		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}
