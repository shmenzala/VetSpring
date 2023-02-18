/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.EnfermedadesDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface EnfermedadesService {
    
    public EnfermedadesDto crearEnfermedad(EnfermedadesDto enfDto);
    
    public List<EnfermedadesDto> listarEnfermedades();
    
    public EnfermedadesDto obtenerEnfermedadPorId(String codigoenf);
    
    public EnfermedadesDto actualizarEnfermedad(EnfermedadesDto enfDto, String codigoenf);
    
    public void eliminarEnfermedad(String codigoenf);
    
}
