/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.VeterinariosDto;
import com.pe.sh.Veterinaria.service.VeterinariosService;
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
@RequestMapping("/api/veterinarios")
public class VeterinariosController {
    
    @Autowired
    private VeterinariosService veterinariosService;
    
    @GetMapping
    public List<VeterinariosDto> listarVeterinarios(){
        return veterinariosService.listarVeterinarios();
    }
    
    @PostMapping("/persona/{codigope}")
    public ResponseEntity<VeterinariosDto> crearVeterinario(@PathVariable(value = "codigope") String id, @RequestBody VeterinariosDto vetDto){
        return new ResponseEntity<>(veterinariosService.crearVeterinario(id, vetDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}/persona/{codigope}")
    public ResponseEntity<VeterinariosDto> obtenerVeterinarioPorId(@PathVariable(value = "id") String id, @PathVariable(value = "codigope") String codigope){
        VeterinariosDto vetDto = veterinariosService.obtenerVeterinarioPorId(id, codigope);
        
        return new ResponseEntity<>(vetDto, HttpStatus.OK);
    }
    
    @PutMapping("/{id}/persona/{codigope}")
    public ResponseEntity<VeterinariosDto> actualizarVeterinario(@PathVariable(value = "id") String id, @PathVariable(value = "codigope") String codigope, @RequestBody VeterinariosDto vetDto){
        VeterinariosDto veterinarioActualizado = veterinariosService.actualizarVeterinario(vetDto, id, codigope);
        
        return new ResponseEntity<>(veterinarioActualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}/persona/{codigope}")
    public ResponseEntity<String> eliminarVeterinario(@PathVariable(value = "id") String id, @PathVariable(value = "codigope") String codigope) {
        veterinariosService.eliminarVeterinario(id, codigope);
        return new ResponseEntity<>("Veterinario eliminada con éxito", HttpStatus.OK);
    }
    
}
