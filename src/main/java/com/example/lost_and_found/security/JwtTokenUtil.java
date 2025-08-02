package com.example.lost_and_found.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationTime;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)          // 新版链式调用
                .subject(subject)        // 替换 setSubject
                .issuedAt(new Date())    // 替换 setIssuedAt
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSigningKey()) // 自动识别算法，移除 SignatureAlgorithm
                .compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())  // 替换 setSigningKey
                .build()
                .parseSignedClaims(token)     // 替换 parseClaimsJws
                .getPayload();               // 替换 getBody
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        } catch (Exception ex) {
            // 处理解析异常（如签名无效、格式错误等）
            return false;
        }
    }
}
