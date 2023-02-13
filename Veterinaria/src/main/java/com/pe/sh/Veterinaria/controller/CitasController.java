/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.CitasDto;
import com.pe.sh.Veterinaria.service.CitasService;
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
@RequestMapping("/api/citas")
public class CitasController {
    
    @Autowired
    private CitasService citasService;
    
    @GetMapping
    public List<CitasDto> listarCitas(){
        return citasService.listarCitas();
    }
    
    @GetMapping("/cliente/{idcl}/veterinario/{idve}/mascota/{idma}")
    public List<CitasDto> listarCitasPorIds(@PathVariable(value = "idcl") String codigocl,
                                            @PathVariable(value = "idve") String codigove, 
                                            @PathVariable(value = "idma") String codigoma){
        return citasService.listarCitasPorIds(codigocl, codigove, codigoma);
    }
    
    @GetMapping("/{idcit}")
    public ResponseEntity<CitasDto> obtenerCitaPorId(@PathVariable(value = "idcit") String codigocit){
        CitasDto citDto = citasService.obtenerCitaPorId(codigocit);
        return new ResponseEntity<>(citDto, HttpStatus.OK);
    }
    
    @PostMapping("/cliente/{idcl}/veterinario/{idve}/mascota/{idma}")
    public ResponseEntity<CitasDto> guardarCita(@PathVariable(value = "idcl") String codigocl,
                                                @PathVariable(value = "idve") String codigove, 
                                                @PathVariable(value = "idma") String codigoma, 
                                                @RequestBody CitasDto citDto){
        return new ResponseEntity<>(citasService.crearCita(codigocl, codigove, codigoma, citDto), HttpStatus.CREATED);
    }
    
     @PutMapping("/{idcit}/cliente/{idcl}/veterinario/{idve}/mascota/{idma}")
    public ResponseEntity<CitasDto> actualizarCita(@PathVariable(value = "idcl") String codigocl,
                                                   @PathVariable(value = "idve") String codigove, 
                                                   @PathVariable(value = "idma") String codigoma, 
                                                   @PathVariable(value = "idcit") String codigocit,
                                                   @RequestBody CitasDto citDto){
        CitasDto citaActualizada = citasService.actualizarCita(codigocl, codigove, codigoma, codigocit, citDto);
        
        return new ResponseEntity<>(citaActualizada, HttpStatus.OK);
    }
    
    @DeleteMapping("/{idcit}/cliente/{idcl}/veterinario/{idve}/mascota/{idma}")
    public ResponseEntity<String> eliminarCitaPorId(@PathVariable(value = "idcl") String codigocl,
                                                   @PathVariable(value = "idve") String codigove, 
                                                   @PathVariable(value = "idma") String codigoma, 
                                                   @PathVariable(value = "idcit") String codigocit){
        citasService.eliminarCitaPorIds(codigocl, codigove, codigoma, codigocit);
        
        return new ResponseEntity<>("Cita eliminada con éxito", HttpStatus.OK);
    }
    
    @DeleteMapping("/{idcit}")
    public ResponseEntity<String> eliminarCita(@PathVariable(value = "idcit") String codigocit){
        citasService.eliminarCita(codigocit);
        
        return new ResponseEntity<>("Cita eliminada con éxito", HttpStatus.OK);
    }
    
    
    
}
