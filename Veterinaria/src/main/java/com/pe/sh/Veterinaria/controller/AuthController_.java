/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.JwtAuthResponseDto_;
import com.pe.sh.Veterinaria.dto.LoginDto_;
import com.pe.sh.Veterinaria.dto.RegisterDto_;
import com.pe.sh.Veterinaria.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<JwtAuthResponseDto_> registerUser(@RequestBody RegisterDto_ regDto) {
        return ResponseEntity.ok(authenticationService.register(regDto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDto_> authenticateUser(@RequestBody LoginDto_ logDto) {
        return ResponseEntity.ok(authenticationService.authenticate(logDto));
    }

}
