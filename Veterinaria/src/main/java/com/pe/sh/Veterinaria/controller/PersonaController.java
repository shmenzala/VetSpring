/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.PersonaDto;
import com.pe.sh.Veterinaria.service.PersonaService;
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
@RequestMapping("/api/personas")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping
    public List<PersonaDto> listarPersonas(){
        return personaService.listarPersonas();
    }
    
    @PostMapping
    public ResponseEntity<PersonaDto> crearPersona(@RequestBody PersonaDto perDto){
        return new ResponseEntity<>(personaService.crearPersona(perDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> obtenerPersonaPorId(@PathVariable(name = "id") String id){
        return ResponseEntity.ok(personaService.obtenerPersonaPorId(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDto> actualizarPersona(@RequestBody PersonaDto perDto, @PathVariable(name = "id") String id) {
        PersonaDto publRespuesta = personaService.actualizarPersona(perDto, id);
        return new ResponseEntity<>(publRespuesta, HttpStatus.OK);
        //return new ResponseEntity<>(personaService.actualizarPersona(perDto, id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable(name = "id") String id) {
        personaService.eliminarPersona(id);
        return new ResponseEntity<>("Persona eliminada con éxito", HttpStatus.OK);
    }
    
    /*@GetMapping("/roles/{id}")
    public ResponseEntity<Map<String, Object>> listarPersonasConRoles(@PathVariable("id") String id) {
        Map<String, Object> res = personaService.getPersonaAndRol(id);

        return ResponseEntity.ok(res);
    }*/
    
}
