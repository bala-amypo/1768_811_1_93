package com.example.demo.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "secret123";

    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token);
        return true;
    }

    public String extractUsername(String token) {
        return extractAll(token).getSubject();
    }

    public Long extractUserId(String token) {
        return extractAll(token).get("userId", Long.class);
    }

    public String extractRole(String token) {
        return extractAll(token).get("role", String.class);
    }

    private Claims extractAll(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
