package com.lhta.foodapp.configurations;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	//private static final String SECRET_KEY = "XwNs04EdzQBecuSVVWO4sw==aaaaaaaaaaaaaaaassssssss";
	private static final int TOKEN_EXPIRE_MILIS = 8 * 60 * 60 * 1000;
	private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	public String extractUsername(String token)
	{
		return extractClaims(token, Claims::getSubject);
	}
	public <T> T extractClaims(String token, Function<Claims, T> claimsResolver)
	{ 
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	public String generateToken(UserDetails userDetails)
	{
		return generateToken(new HashMap<>(), userDetails);
	}
	public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails)
	{
		return Jwts
				.builder()
				.setClaims(extractClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRE_MILIS))
				.signWith(key)
				.compact();
	}
	public boolean isTokenValid(String token, UserDetails userDetails)
	{
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	private Date extractExpiration(String token) {
		return extractClaims(token, Claims::getExpiration);
	}
	private Claims extractAllClaims(String token)
	{
		return Jwts
			.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token)
			.getBody();
	}
	/*
	 * public Key getSignInKey() { byte[] keyBytes =
	 * Decoders.BASE64.decode(SECRET_KEY); return Keys.hmacShaKeyFor(keyBytes); }
	 */
}

