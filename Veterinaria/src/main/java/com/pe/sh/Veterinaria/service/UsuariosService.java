/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.UsuariosDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface UsuariosService {
    
    public UsuariosDto crearUsuario(String codigove, UsuariosDto usuDto);
    
    public List<UsuariosDto> listarUsuarios();
    
    public UsuariosDto obtenerUsuarioPorId(String id, String codigove);
    
    public UsuariosDto actualizarUsuario(UsuariosDto usuDto, String id, String codigove);
    
    public void eliminarUsuario(String id, String codigove);
    
}
