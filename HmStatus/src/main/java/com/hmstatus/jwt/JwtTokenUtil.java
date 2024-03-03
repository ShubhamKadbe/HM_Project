package com.hmstatus.jwt;

import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hmstatus.user.UserCredentials;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil {

	private static Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);
	private static final long EXPIRE_DURATION = 1 * 60 * 60 * 1000; // 1 hour

	@Value("${app.jwt.secret}")
	private String secretKey;

	public String generateAccessToken(UserCredentials userCred) {
		return Jwts.builder().setSubject(userCred.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();
	}

	public boolean validateAccessToken(String token) throws ExpiredJwtException {

		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

			return true;

		} catch (ExpiredJwtException e) {
			LOGGER.error("JWT Expired", e);
		} catch (IllegalArgumentException e) {
			LOGGER.error("Token is null, empty or has only whitespaces", e);
		} catch (MalformedJwtException e) {
			LOGGER.error("Jwt is invalid", e);
		} catch (UnsupportedJwtException e) {
			LOGGER.error("JWT is not supported", e);
		} catch (SignatureException e) {
			LOGGER.error("Signature validation failed", e);
		}
		return false;
	}

	public String getSubject(String token) {
		return parseClaims(token).getSubject();
	}

	private Claims parseClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
}
