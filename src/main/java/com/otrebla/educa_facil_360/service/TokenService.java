package com.otrebla.educa_facil_360.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {
    private final Algorithm algorithm;
    
    public TokenService(@Value("${api.security.secret") String secret) {
        this.algorithm = Algorithm.HMAC256(secret);
    }
    
    public String generateToken(String username, String role, byte[] profilePicture) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withExpiresAt(generateExpiration())
                .sign(algorithm);
    }
    
    private Instant generateExpiration() {
        return Instant.now()
                .plus(2, ChronoUnit.HOURS);
    }
    
    public String validateToken(String token) {
        return JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();
    }
    
}
