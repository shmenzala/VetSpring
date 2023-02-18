/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.VacunasDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface VacunasService {
    
    public VacunasDto crearVacunas(VacunasDto vacDto);
    
    public List<VacunasDto> listarVacunas();
    
    public VacunasDto obtenerVacunasPorId(String codigovac);
    
    public VacunasDto actualizarVacunas(VacunasDto vacDto, String codigovac);
    
    public void eliminarVacunas(String codigovac);
    
}
