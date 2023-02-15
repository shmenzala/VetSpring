/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.MascotasDto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shmen
 */
public interface MascotasService {
    
    public MascotasDto crearMascota(MascotasDto masDto);
    
    public List<MascotasDto> listarMascotas();
    
    public MascotasDto obtenerMascotaPorId(String id);
    
    public MascotasDto actualizarMascota(MascotasDto masDto, String id);
    
    public void eliminarMascota(String id);
    
    public List<MascotasDto> listarMascotasPorClienteId(String clienteid);
    
    public MascotasDto asignarDuenoALaMascota(String id, String clienteid);
    
}
