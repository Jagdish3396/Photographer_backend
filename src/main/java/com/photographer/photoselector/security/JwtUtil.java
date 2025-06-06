package com.photographer.photoselector.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;

@Component
public class JwtUtil {
	
	

    // Load from environment variables (recommended for production)
    @Value("${jwt.secret}") 
    private String jwtSecret; // Should be 64+ chars long for HS512

    @Value("${jwt.expirationMs}")
    private long jwtExpirationMs; // e.g., 86400000 (1 day)

    // Convert the plaintext secret into a secure SecretKey
    private SecretKey getSigningKey() {
        // If jwtSecret is Base64-encoded (recommended):
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);

        // If jwtSecret is a raw string (less secure):
        // return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)  // Old method (pre-0.11.x)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, getSigningKey())  // Old signing method
            .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey()) // Old method (0.9.x)
                .parseClaimsJws(token) // Old parsing method
                .getBody()
                .getSubject();
    }

 // For JJWT 0.9.x only
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
               .setSigningKey(getSigningKey())
               .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }}