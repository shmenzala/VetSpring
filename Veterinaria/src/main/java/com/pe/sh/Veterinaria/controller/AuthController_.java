/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.JwtAuthResponseDto_;
import com.pe.sh.Veterinaria.dto.LoginDto_;
import com.pe.sh.Veterinaria.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController_ {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDto_> authenticateUser(@RequestBody LoginDto_ logDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logDto.getUsername(), logDto.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        //Obtener token de jwtTokenProvider
        String token = jwtTokenProvider.generarToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponseDto_(token));
        
        //return new ResponseEntity<>("Ha iniciado sesión con éxito", HttpStatus.OK);
    }
    
}
