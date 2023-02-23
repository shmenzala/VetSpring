/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.EnfermedadesDto;
import com.pe.sh.Veterinaria.service.EnfermedadesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/enfermedades")
public class EnfermedadesController {
    
    @Autowired
    private EnfermedadesService enfermedadesService;
    
    @GetMapping
    public List<EnfermedadesDto> listarEnfermedades(){
        return enfermedadesService.listarEnfermedades();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<EnfermedadesDto> crearEnfermedad(@RequestBody EnfermedadesDto enfDto){
        return new ResponseEntity<>(enfermedadesService.crearEnfermedad(enfDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{codigoenf}")
    public ResponseEntity<EnfermedadesDto> obtenerEnfermedadPorId(@PathVariable(value = "codigoenf") String codigoenf){
        return ResponseEntity.ok(enfermedadesService.obtenerEnfermedadPorId(codigoenf));
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{codigoenf}")
    public ResponseEntity<EnfermedadesDto> actualizarEnfermedad(@RequestBody EnfermedadesDto enfDto, @PathVariable(value = "codigoenf") String codigoenf){
        EnfermedadesDto enfRespuesta = enfermedadesService.actualizarEnfermedad(enfDto, codigoenf);
        
        return new ResponseEntity<>(enfRespuesta, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{codigoenf}")
    public ResponseEntity<String> eliminarEnfermedad(@PathVariable(value = "codigoenf") String codigoenf){
        enfermedadesService.eliminarEnfermedad(codigoenf);
        return new ResponseEntity<>("Enfermedad eliminada con éxito", HttpStatus.OK);
    }
    
    
}
