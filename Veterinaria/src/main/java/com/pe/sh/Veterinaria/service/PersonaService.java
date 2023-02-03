/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.PersonaDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface PersonaService {
    
    public PersonaDto crearPersona(PersonaDto perDto);
    
    public List<PersonaDto> listarPersonas();
    
    public PersonaDto obtenerPersonaPorId(String id);
    
    public PersonaDto actualizarPersona(PersonaDto perDto, String id);
    
    public void eliminarPersona(String id);
    
}
