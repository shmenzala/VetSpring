/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.security;

import com.pe.sh.Veterinaria.exceptions.VetAppException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author shmen
 */
@Component
public class JwtTokenProvider {
    
    @Value("${app.jwt-secret}")
    private String jwtSecret;
    
    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;
    
    public String generarToken(Authentication authentication){
        String username = authentication.getName();
        List<String> roles = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        Date fechaActual = new Date();
        Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpirationInMs);
        
        String token = Jwts.builder().setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date()).setExpiration(fechaExpiracion)
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes()).compact();
        
        return token;
    }
    
    public String obtenerUsernameDelJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret.getBytes())
                .parseClaimsJws(token).getBody();
        
        return claims.getSubject();
    }
    
    public boolean validarToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "Firma JWT no válida.");
        } catch (MalformedJwtException ex) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "Token JWT no válida.");
        } catch (ExpiredJwtException ex) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "Token JWT caducado.");
        } catch (UnsupportedJwtException ex) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "Token JWT no compatible.");
        } catch (IllegalArgumentException ex) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "La cadena Claims JWT está vacía.");
        }
    }
    
}
