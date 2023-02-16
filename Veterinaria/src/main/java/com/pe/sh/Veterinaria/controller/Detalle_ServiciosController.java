/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.Detalle_ServiciosDto;
import com.pe.sh.Veterinaria.service.Detalle_ServiciosService;
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
@RequestMapping("/api/detServ")
public class Detalle_ServiciosController {
    
    @Autowired
    private Detalle_ServiciosService detalle_ServiciosService;
    
    @GetMapping
    public List<Detalle_ServiciosDto> listarDetServ(){
        return detalle_ServiciosService.listarDetServ();
    }
    
    @GetMapping("/servicio/{idser}/cita/{idcit}")
    public List<Detalle_ServiciosDto> listarDetServPorIds(@PathVariable(value = "idser") String codigoser,
                                                          @PathVariable(value = "idcit") String codigocit){
        return detalle_ServiciosService.listarDetServPorIds(codigoser, codigocit);
    }
    
    @GetMapping("/{iddsv}")
    public ResponseEntity<Detalle_ServiciosDto> obtenerDetServPorId(@PathVariable(value = "iddsv") String codigodet_ser){
        Detalle_ServiciosDto dsvDto = detalle_ServiciosService.obtenerDetServPorId(codigodet_ser);
        return new ResponseEntity<>(dsvDto, HttpStatus.OK);
    }
    
    @PostMapping("/servicio/{idser}/cita/{idcit}")
    public ResponseEntity<Detalle_ServiciosDto> guardarDetServ(@PathVariable(value = "idser") String codigoser,
                                                               @PathVariable(value = "idcit") String codigocit,
                                                               @RequestBody Detalle_ServiciosDto dsvDto){
        return new ResponseEntity<>(detalle_ServiciosService.crearDetServ(codigoser, codigocit, dsvDto), HttpStatus.CREATED);
    }
    
    @PutMapping("/{iddsv}/servicio/{idser}/cita/{idcit}")
    public ResponseEntity<Detalle_ServiciosDto> actualizarDetServ(@PathVariable(value = "idser") String codigoser,
                                                                  @PathVariable(value = "idcit") String codigocit,
                                                                  @PathVariable(value = "iddsv") String codigodet_ser,
                                                                  @RequestBody Detalle_ServiciosDto dsvDto){
        Detalle_ServiciosDto detServActualizado = detalle_ServiciosService.actualizarDetServ(codigoser, codigocit, codigodet_ser, dsvDto);
        
        return new ResponseEntity<>(detServActualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{idsv}/servicio/{idser}/cita/{idcit}")
    public ResponseEntity<String> eliminarDetServPorId(@PathVariable(value = "idser") String codigoser,
                                                       @PathVariable(value = "idcit") String codigocit,
                                                       @PathVariable(value = "iddsv") String codigodet_ser){
        detalle_ServiciosService.eliminarDetServPorIds(codigoser, codigocit, codigodet_ser);
        
        return new ResponseEntity<>("Detalle_Servicio eliminado con éxito", HttpStatus.OK);
    }
    
    @DeleteMapping("/{iddsv}")
    public ResponseEntity<String> eliminarDetServ(@PathVariable(value = "iddsv") String codigodet_ser){
        detalle_ServiciosService.eliminarDetServ(codigodet_ser);
        
        return new ResponseEntity<>("Detalle_Servicio eliminada con éxito", HttpStatus.OK);
    }
    
}
