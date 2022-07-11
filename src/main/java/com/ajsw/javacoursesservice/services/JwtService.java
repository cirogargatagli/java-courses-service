package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.dtos.response.JwtUserDetails;
import com.ajsw.javacoursesservice.models.entities.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Component
public class JwtService {

    @Value("${jwt.private-key}")
    private String signedKey;

    public String generateToken(Account account) {
        Claims claims = Jwts.claims().setSubject(Integer.toString(account.getIdAccount()));
        claims.setIssuedAt(new Date(System.currentTimeMillis()));
        claims.setExpiration(new Date(System.currentTimeMillis() + (1000*60*60*2)));
        claims.put("accountEmail", account.getEmail());
        claims.put("role", account.getRole().getDescription());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, signedKey)
                .compact();
    }

    public JwtUserDetails validateToken(String authToken, String role) {
        try {
            String[] token = authToken.split("\"");
            Claims claims = Jwts.parser().setSigningKey(signedKey).parseClaimsJws(token[1]).getBody();
            Date expireTime = claims.getExpiration();

            if (expireTime.before(new Date(System.currentTimeMillis()))) {
                throw new RuntimeException("token is expired");
            }
            //Guardar el JwtUserDetails
            JwtUserDetails jwtUserDetails = JwtUserDetails
                    .builder()
                    .accountEmail((String) claims.get("accountEmail"))
                    .role((String) claims.get("role"))
                    .accountId(claims.getSubject())
                    .build();
            //if rol no coincide
            if(role.isBlank() || !jwtUserDetails.getRole().equals(role)){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized. The role is not as expected\n");
            }
            return jwtUserDetails;
        } catch (Exception ex) {
            throw new RuntimeException("token is not valid");
        }
    }
}
