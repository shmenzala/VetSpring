/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.ServiciosDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface ServiciosService {
    
    public ServiciosDto crearServicio(ServiciosDto serDto);
    
    public List<ServiciosDto> listarServicios();
    
    public ServiciosDto obtenerServicioPorId(String id);
    
    public ServiciosDto actualizarServicio(ServiciosDto serDto, String id);
    
    public void eliminarServicio(String id);
    
}
