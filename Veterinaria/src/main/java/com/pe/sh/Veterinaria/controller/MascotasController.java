/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.MascotasDto;
import com.pe.sh.Veterinaria.service.MascotasService;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/mascotas")
public class MascotasController {
    
    @Autowired
    private MascotasService mascotasService;
    
    @GetMapping
    public List<MascotasDto> listarMascotas(){
        return mascotasService.listarMascotas();
    }
    
    @PostMapping
    public ResponseEntity<MascotasDto> crearMascota(@RequestBody MascotasDto masDto){
        return new ResponseEntity<>(mascotasService.crearMascota(masDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MascotasDto> obtenerMascotaPorId(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(mascotasService.obtenerMascotaPorId(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MascotasDto> actualizarMascota(@RequestBody MascotasDto masDto, @PathVariable(name = "id") String id) {
        MascotasDto publRespuesta = mascotasService.actualizarMascota(masDto, id);
        return new ResponseEntity<>(publRespuesta, HttpStatus.OK);
        //return new ResponseEntity<>(personaService.actualizarPersona(perDto, id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable(name = "id") String id) {
        mascotasService.eliminarMascota(id);
        return new ResponseEntity<>("Persona eliminada con éxito", HttpStatus.OK);
    }
    
    @GetMapping("/cliente/{idcl}")
    public List<MascotasDto> listarMascotas(@PathVariable(name = "idcl") String idcl){
        return mascotasService.listarMascotasPorClienteId(idcl);
    }
    
}
