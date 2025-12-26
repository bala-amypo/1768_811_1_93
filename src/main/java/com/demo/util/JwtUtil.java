// util/JwtUtil.java
package com.example.demo.util;

@Component
public class JwtUtil {

    private final String SECRET = "secret123";

    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+86400000))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }

    public boolean validateToken(String token, UserDetails user) {
        return extractUsername(token).equals(user.getUsername());
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
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
