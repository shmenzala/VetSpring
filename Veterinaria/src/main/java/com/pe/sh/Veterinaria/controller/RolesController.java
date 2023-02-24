/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.RolesDto;
import com.pe.sh.Veterinaria.service.RolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/roles")
public class RolesController {
    
    @Autowired
    private RolesService rolesService;
    
    @GetMapping
    public List<RolesDto> listarRoles(){
        return rolesService.listarRoles();
    }
    
    @PostMapping
    public ResponseEntity<RolesDto> crearRol(@RequestBody RolesDto rolDto){
        return new ResponseEntity<>(rolesService.crearRol(rolDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{codigorol}")
    public ResponseEntity<RolesDto> obtenerRolPorId(@PathVariable(value = "codigorol") String codigorol){
        return ResponseEntity.ok(rolesService.obtenerRolesPorId(codigorol));
    }
    
    @PutMapping("/{codigorol}")
    public ResponseEntity<RolesDto> actualizarRol(@RequestBody RolesDto rolDto, @PathVariable(value = "codigorol") String codigorol){
        RolesDto rolRespuesta = rolesService.actualizarRol(rolDto, codigorol);
        
        return new ResponseEntity<>(rolRespuesta, HttpStatus.OK);
    }
    
    @DeleteMapping("/{codigorol}")
    public ResponseEntity<String> eliminarRol(@PathVariable(value = "codigorol") String codigorol){
        rolesService.eliminarRol(codigorol);
        return new ResponseEntity<>("Rol eliminado con éxito", HttpStatus.OK);
    }
    
}
