package com.security.test.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${app.secret}")
	private String secret;

	// 1. Generate Token
	@SuppressWarnings("deprecation")
	public String generateToken(String subject) {

		return Jwts.builder().setSubject(subject).setIssuer("RameshIT")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	// 2. Read Claims
	@SuppressWarnings("deprecation")
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}

	// 3. Read Expire Date
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}

	// 4. Read Subject/username
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
}
