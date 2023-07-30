/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.JwtAuthResponseDto_;
import com.pe.sh.Veterinaria.dto.LoginDto_;
import com.pe.sh.Veterinaria.dto.RegisterDto_;
import com.pe.sh.Veterinaria.exceptions.ResourceNotFoundException;
import com.pe.sh.Veterinaria.exceptions.VetAppException;
import com.pe.sh.Veterinaria.model.Roles;
import com.pe.sh.Veterinaria.model.Usuarios;
import com.pe.sh.Veterinaria.model.Veterinarios;
import com.pe.sh.Veterinaria.repository.RolesRepository;
import com.pe.sh.Veterinaria.repository.UsuariosRepository;
import com.pe.sh.Veterinaria.repository.VeterinariosRepository;
import com.pe.sh.Veterinaria.security.JwtTokenProvider;
import java.util.Collections;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private VeterinariosRepository veterinariosRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override//ROL USUARIO, ESPECIFICAR QUE VET ES, y su contraseña
    public JwtAuthResponseDto_ register(RegisterDto_ regDto) {

        if (usuariosRepository.existsByNombreus(regDto.getUsername())) {
            throw new VetAppException(HttpStatus.BAD_REQUEST, "Ese nombre de usuario ya existe");
        }
        
        Usuarios usuario = new Usuarios();
        usuario.setNombreus(regDto.getUsername());
        usuario.setContraus(passwordEncoder.encode(regDto.getPassword()));

        Veterinarios veterinario = veterinariosRepository.findById(regDto.getCodigove())
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario", "id", regDto.getCodigove()));
        usuario.setVeterinario(veterinario);

        Roles rol = rolesRepository.findByNombre("ROLE_USER").get();
        usuario.setRoles(Collections.singleton(rol));

        usuariosRepository.save(usuario);

        String token = jwtTokenProvider.generateToken(usuario);

        return new JwtAuthResponseDto_(token);
    }

    @Override
    public JwtAuthResponseDto_ authenticate(LoginDto_ logDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        logDto.getUsername(),
                        logDto.getPassword()
                )
        );

        Usuarios usuario = usuariosRepository.findByNombreus(logDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        
        usuario.getRoles().forEach((rol)-> System.out.println(rol.getNombre()));
        System.out.println("AUTORIDADES DEL USER ADMIN " + usuario.getAuthorities());
        
        String token = jwtTokenProvider.generateToken(usuario);
        return new JwtAuthResponseDto_(token);
    }

}
