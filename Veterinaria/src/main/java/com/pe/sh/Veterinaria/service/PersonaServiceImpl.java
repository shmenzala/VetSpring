/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.PersonaDto;
import com.pe.sh.Veterinaria.model.Persona;
import com.pe.sh.Veterinaria.repository.PersonaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public PersonaDto crearPersona(PersonaDto perDto) {
        Persona persona = mapearEntidad(perDto);
        Persona nuevaPersona = personaRepository.save(persona);
        
        PersonaDto respPersona = mapearDto(nuevaPersona);
        
        return respPersona;
    }

    @Override
    public List<PersonaDto> listarPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream().map(persona -> mapearDto(persona)).collect(Collectors.toList());
    }

    @Override
    public PersonaDto obtenerPersonaPorId(String id) {
        Persona persona = personaRepository.findById(id).orElseThrow(null);
        return mapearDto(persona);
    }

    @Override
    public PersonaDto actualizarPersona(PersonaDto perDto, String id) {
        Persona persona = personaRepository.findById(id).orElseThrow(null);
        
        persona.setNombre(perDto.getNombre());
        persona.setCelular(perDto.getCelular());
        persona.setTelefono(perDto.getTelefono());
        persona.setCorreo(perDto.getCorreo());
        persona.setSexo(perDto.getSexo());
        persona.setDni(perDto.getDni());
        
        Persona personaActualizada = personaRepository.save(persona);
        
        return mapearDto(personaActualizada);
    }

    @Override
    public void eliminarPersona(String id) {
        Persona persona = personaRepository.findById(id).orElseThrow(null);
       
        personaRepository.delete(persona);
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Persona mapearEntidad(PersonaDto perDto){
        Persona per = modelMapper.map(perDto, Persona.class);
        return per;
    }
    
    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private PersonaDto mapearDto(Persona per){
        PersonaDto perDto = modelMapper.map(per, PersonaDto.class);
        return perDto;
    }
    
}
