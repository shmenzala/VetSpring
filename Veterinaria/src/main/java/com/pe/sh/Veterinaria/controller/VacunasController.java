/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.VacunasDto;
import com.pe.sh.Veterinaria.service.VacunasService;
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
@RequestMapping("/api/vacunas")
public class VacunasController {
    
    @Autowired
    private VacunasService vacunasService;
    
    @GetMapping
    public List<VacunasDto> listarVacunas(){
        return vacunasService.listarVacunas();
    }
    
    @PostMapping
    public ResponseEntity<VacunasDto> crearVacuna(@RequestBody VacunasDto vacDto){
        return new ResponseEntity<>(vacunasService.crearVacunas(vacDto), HttpStatus.CREATED);
    }
    
    @GetMapping("/{codigovac}")
    public ResponseEntity<VacunasDto> obtenerVacunaPorId(@PathVariable(value = "codigovac") String codigovac){
        return ResponseEntity.ok(vacunasService.obtenerVacunasPorId(codigovac));
    }
    
    @PutMapping("/{codigovac}")
    public ResponseEntity<VacunasDto> actualizarVacuna(@RequestBody VacunasDto vacDto, @PathVariable(value = "codigovac") String codigovac){
        VacunasDto vacRespuesta = vacunasService.actualizarVacunas(vacDto, codigovac);
        
        return new ResponseEntity<>(vacRespuesta, HttpStatus.OK);
    }
    
    @DeleteMapping("/{codigovac}")
    public ResponseEntity<String> eliminarVacuna(@PathVariable(value = "codigovac") String codigovac){
        vacunasService.eliminarVacunas(codigovac);
        return new ResponseEntity<>("Vacuna eliminada con éxito", HttpStatus.OK);
    }
    
}
