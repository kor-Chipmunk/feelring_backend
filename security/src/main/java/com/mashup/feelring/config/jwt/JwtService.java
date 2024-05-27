package com.mashup.feelring.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.ZIP;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.time.Duration;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtService {

    @Value("${spring.application.name}")
    private String issuer;

    @Value("${jwt.access-token.expiration}")
    private Long accessTokenExpirationSeconds;

    private final SecretKey secretKey;

    public JwtService(
            @Value("${jwt.access-token.secret-key}")
            String secretKey
    ) {
        final byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey);
        this.secretKey = Keys.hmacShaKeyFor(secretKeyBytes);
    }

    public String generateAccessToken(Long id, String userId, Date baseDate) {
        final long expirationMillis = baseDate.getTime() + Duration.ofSeconds(accessTokenExpirationSeconds).toMillis();
        final Date expiration = new Date(expirationMillis);

        return Jwts.builder()
                .header()
                    .type(Header.JWT_TYPE)
                .and()
                .issuer(issuer)
                .expiration(expiration)
                .subject(userId)
                .claim("id", id)
                .compressWith(ZIP.GZIP)
                .signWith(secretKey)
                .compact();
    }

    public Claims getPayload(String token) {
        final Jws<Claims> claims = parseClaims(token);
        return claims.getPayload();
    }

    private Jws<Claims> parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token);
    }
}
