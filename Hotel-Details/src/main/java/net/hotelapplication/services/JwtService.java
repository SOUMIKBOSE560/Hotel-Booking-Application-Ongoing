package net.hotelapplication.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {


    @Value("${secret}")
    private String SECRET_KEY;

    private Key signKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //EXTRACT FROM JWT TOKEN
    public boolean extractUsername(String token, String username) throws NoSuchAlgorithmException {
        System.out.println("JWT TOKEN IS : " + token);
        return extractClaim(token.substring(7), Claims::getSubject).equals(username);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws NoSuchAlgorithmException {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(signKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}
