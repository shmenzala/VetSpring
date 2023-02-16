/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.ServiciosDto;
import com.pe.sh.Veterinaria.service.ServiciosService;
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
@RequestMapping("/api/servicios")
public class ServiciosController {
    
    @Autowired
    private ServiciosService serviciosService;
    
    @GetMapping
    public List<ServiciosDto> listarServicios(){
        return serviciosService.listarServicios();
    }
    
    @PostMapping
    public ResponseEntity<ServiciosDto> crearServicio(@RequestBody ServiciosDto serDto){
        return new ResponseEntity<>(serviciosService.crearServicio(serDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ServiciosDto> obtenerServicioPorId(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(serviciosService.obtenerServicioPorId(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ServiciosDto> actualizarServicio(@RequestBody ServiciosDto serDto, @PathVariable(name = "id") String id) {
        ServiciosDto publRespuesta = serviciosService.actualizarServicio(serDto, id);
        return new ResponseEntity<>(publRespuesta, HttpStatus.OK);
        //return new ResponseEntity<>(personaService.actualizarPersona(perDto, id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarServicio(@PathVariable(name = "id") String id) {
        serviciosService.eliminarServicio(id);
        return new ResponseEntity<>("Mascota eliminada con éxito", HttpStatus.OK);
    }
    
    
}
