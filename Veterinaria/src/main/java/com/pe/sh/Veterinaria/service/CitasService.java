/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.CitasDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface CitasService {
    
    public CitasDto crearCita(String codigocl, String codigove, String codigoma, CitasDto citDto);
    
    public List<CitasDto> listarCitas();
    
    public List<CitasDto> listarCitasPorIds(String codigocl, String codigove, String codigoma);
    
    public CitasDto obtenerCitaPorId(String codigocit);
    
    public CitasDto actualizarCita(String codigocl, String codigove, String codigoma, String codigocit, CitasDto citDto);
    
    public void eliminarCitaPorIds(String codigocl, String codigove, String codigoma, String codigocit);
    
    public void eliminarCita(String codigocit);
    
}
