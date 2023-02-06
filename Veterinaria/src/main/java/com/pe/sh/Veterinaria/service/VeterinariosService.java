/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.VeterinariosDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface VeterinariosService {
    
    public VeterinariosDto crearVeterinario(String codigope, VeterinariosDto vetDto);
    
    public List<VeterinariosDto> listarVeterinarios();
    
    public VeterinariosDto obtenerVeterinarioPorId(String id, String codigope);
    
    public VeterinariosDto actualizarVeterinario(VeterinariosDto vetDto, String id, String codigope);
    
    public void eliminarVeterinario(String id, String codigope);
    
}
