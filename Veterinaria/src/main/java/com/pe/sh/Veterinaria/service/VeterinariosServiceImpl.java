/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.VeterinariosDto;
import com.pe.sh.Veterinaria.model.Persona;
import com.pe.sh.Veterinaria.model.Veterinarios;
import com.pe.sh.Veterinaria.repository.PersonaRepository;
import com.pe.sh.Veterinaria.repository.VeterinariosRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class VeterinariosServiceImpl implements VeterinariosService{
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private VeterinariosRepository veterinariosRepository;
    
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public VeterinariosDto crearVeterinario(String codigope, VeterinariosDto vetDto) {
        Veterinarios veterinario = mapearEntidad(vetDto);
        
        Persona persona = personaRepository.findById(codigope).orElseThrow(null);
        veterinario.setPersonavet(persona);
        
        Veterinarios nuevoVeterinario = veterinariosRepository.save(veterinario);

        return mapearDto(nuevoVeterinario);
    }

    @Override
    public List<VeterinariosDto> listarVeterinarios() {
        List<Veterinarios> veterinarios = veterinariosRepository.findAll();
        return veterinarios.stream().map(veterinario -> mapearDto(veterinario)).collect(Collectors.toList());
    }

    @Override
    public VeterinariosDto obtenerVeterinarioPorId(String id, String codigope) {
        Persona persona = personaRepository.findById(codigope).orElseThrow(null);
        
        Veterinarios veterinario = veterinariosRepository.findById(id).orElseThrow(null);
        
        if(!veterinario.getPersonavet().getCodigope().equals(persona.getCodigope())){
            return mapearDto(veterinario);
        }
        
        return mapearDto(veterinario);
    }

    @Override
    public VeterinariosDto actualizarVeterinario(VeterinariosDto vetDto, String id, String codigope) {
        Persona persona = personaRepository.findById(codigope).orElseThrow(null);
        
        Veterinarios veterinario = veterinariosRepository.findById(id).orElseThrow(null);
        
        if(!veterinario.getPersonavet().getCodigope().equals(persona.getCodigope())){
            return mapearDto(veterinario);
        }
        
        veterinario.setAnio_cont(vetDto.getAnio_cont());
        veterinario.setSalario(vetDto.getSalario());

        Veterinarios vetActualizado = veterinariosRepository.save(veterinario);
        
        return mapearDto(vetActualizado);
    }

    @Override
    public void eliminarVeterinario(String id, String codigope) {
        
        Persona persona = personaRepository.findById(codigope).orElseThrow(null);
        
        Veterinarios veterinario = veterinariosRepository.findById(id).orElseThrow(null);
        
        if(!veterinario.getPersonavet().getCodigope().equals(persona.getCodigope())){
            return ;
        }
        
        veterinariosRepository.delete(veterinario);
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Veterinarios mapearEntidad(VeterinariosDto vetDto){
        Veterinarios vet = modelMapper.map(vetDto, Veterinarios.class);
        return vet;
    }
    
    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private VeterinariosDto mapearDto(Veterinarios vet){
        VeterinariosDto vetDto = modelMapper.map(vet, VeterinariosDto.class);
        return vetDto;
    }
    
    
    
}
