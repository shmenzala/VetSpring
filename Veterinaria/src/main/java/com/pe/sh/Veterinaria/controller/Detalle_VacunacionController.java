/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.Detalle_VacunacionDto;
import com.pe.sh.Veterinaria.service.Detalle_VacunacionService;
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
@RequestMapping("/api/detVac")
public class Detalle_VacunacionController {
    
    @Autowired
    private Detalle_VacunacionService detalle_VacunacionService;
    
    @GetMapping
    public List<Detalle_VacunacionDto> listarDetVacs(){
        return detalle_VacunacionService.listarDetVacs();
    }
    
    @PostMapping("/cita/{codigocit}")
    public ResponseEntity<Detalle_VacunacionDto> crearDetVac(@RequestBody Detalle_VacunacionDto dtvDto, @PathVariable(value = "codigocit") String codigocit){
        return new ResponseEntity<>(detalle_VacunacionService.crearDetVac(dtvDto, codigocit), HttpStatus.CREATED);
    }
    
    @GetMapping("/{codigodet_vac}")
    public ResponseEntity<Detalle_VacunacionDto> obtenerDetVacPorId(@PathVariable(value = "codigodet_vac") String codigodet_vac){
        return ResponseEntity.ok(detalle_VacunacionService.obtenerDetVacPorId(codigodet_vac));
    }
    
    @PutMapping("/{codigodet_vac}")
    public ResponseEntity<Detalle_VacunacionDto> actualizarDetVac(@RequestBody Detalle_VacunacionDto dtvDto, @PathVariable(value = "codigodet_vac") String codigodet_vac){
        
        Detalle_VacunacionDto detVacActualizado = detalle_VacunacionService.actualizarDetVac(dtvDto, codigodet_vac);
        
        return new ResponseEntity<>(detVacActualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{codigodet_vac}")
    public ResponseEntity<String> eleiminarDetVac(@PathVariable(value = "codigodet_vac") String codigodet_vac){
        detalle_VacunacionService.eliminarDetVac(codigodet_vac);
        
        return new ResponseEntity<>("Detalle_Vacunacion eliminado con éxito", HttpStatus.OK);
    }
    
    @GetMapping("/cita/{codigocit}")
    public List<Detalle_VacunacionDto> listarDetVacsPorCitaId(@PathVariable(name = "codigocit") String codigocit){
        return detalle_VacunacionService.listarDetVacsPorCitaId(codigocit);
    }
    
    @PutMapping("/{codigodet_vac}/enfermedad/{codigoenf}")
    public Detalle_VacunacionDto asignarEnfermedadesALaDetVac(@PathVariable(value = "codigodet_vac") String codigodet_vac,
                                                              @PathVariable(name = "codigoenf") String codigoenf){
        return detalle_VacunacionService.asignarEnfermedadALaDetVac(codigodet_vac, codigoenf);
    }
    
    @PutMapping("/{codigodet_vac}/vacuna/{codigovac}")
    public Detalle_VacunacionDto asignarVacunasALaDetVac(@PathVariable(value = "codigodet_vac") String codigodet_vac,
                                                         @PathVariable(name = "codigovac") String codigovac){
        return detalle_VacunacionService.asignarVacunaALaDetVac(codigodet_vac, codigovac);
    }
    
}
