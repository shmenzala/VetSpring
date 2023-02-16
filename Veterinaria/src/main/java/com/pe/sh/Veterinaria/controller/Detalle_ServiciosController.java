/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.controller;

import com.pe.sh.Veterinaria.dto.Detalle_ServiciosDto;
import com.pe.sh.Veterinaria.service.Detalle_ServiciosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
