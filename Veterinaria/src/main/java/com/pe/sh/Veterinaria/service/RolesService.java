/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.RolesDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface RolesService {
    
    public RolesDto crearRol(RolesDto rolDto);
    
    public List<RolesDto> listarRoles();
    
    public RolesDto obtenerRolesPorId(String codigorol);
    
    public RolesDto actualizarRol(RolesDto rolDto, String codigorol);
    
    public void eliminarRol(String codigorol);
    
}
