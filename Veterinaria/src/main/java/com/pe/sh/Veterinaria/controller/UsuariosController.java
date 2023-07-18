/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.UsuariosDto;
import com.pe.sh.Veterinaria.service.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shmen
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuariosService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UsuariosDto> listarUsuarios(){
        return usuariosService.listarUsuarios();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/veterinario/{codigove}/rol/{codigorol}")
    public ResponseEntity<UsuariosDto> crearUsuario(@PathVariable(value = "codigove") String id,
                                                    @PathVariable(value = "codigorol") String codigorol,
                                                    @RequestBody UsuariosDto usuDto){
        return new ResponseEntity<>(usuariosService.crearUsuario(codigorol, id, usuDto), HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/veterinario/{codigove}")
    public ResponseEntity<UsuariosDto> obtenerUsuarioPorId(@PathVariable(value = "id") String id, @PathVariable(value = "codigove") String codigope){
        UsuariosDto usuDto = usuariosService.obtenerUsuarioPorId(id, codigope);
        
        return new ResponseEntity<>(usuDto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/veterinario/{codigove}")
    public ResponseEntity<UsuariosDto> actualizarUsuario(@PathVariable(value = "id") String id, @PathVariable(value = "codigove") String codigope, @RequestBody UsuariosDto usuDto){
        UsuariosDto usuarioActualizado = usuariosService.actualizarUsuario(usuDto, id, codigope);
        
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}/veterinario/{codigove}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable(value = "id") String id, @PathVariable(value = "codigove") String codigope) {
        usuariosService.eliminarUsuario(id, codigope);
        return new ResponseEntity<>("Usuario eliminada con éxito", HttpStatus.OK);
    }
    
}
