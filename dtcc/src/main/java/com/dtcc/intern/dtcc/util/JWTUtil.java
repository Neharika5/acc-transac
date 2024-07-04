package com.dtcc.intern.dtcc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private final String SECRET = "narselmary";
    private static final int JWT_TOKEN_VALIDITY = 5 * 60 * 60; 
    private static final String CLAIM_KEY_USER_ID = "userId";  

    public String generateToken(String username, Long userId) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        try {
            Date issuedAt = new Date();
            Date expiresAt = new Date(issuedAt.getTime() + JWT_TOKEN_VALIDITY * 1000);

            return JWT.create()
                    .withSubject(username)
                    .withClaim(CLAIM_KEY_USER_ID, userId)
                    .withExpiresAt(expiresAt)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Failed to create JWT token", exception);
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Failed to extract username from JWT token", e);
        }
    }

    public boolean validateToken(String token, String username) {
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);
            return decodedJWT.getSubject().equals(username);
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
