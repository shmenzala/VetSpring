/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.EnfermedadesDto;
import com.pe.sh.Veterinaria.exceptions.ResourceNotFoundException;
import com.pe.sh.Veterinaria.model.Enfermedades;
import com.pe.sh.Veterinaria.repository.EnfermedadesRepository;
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
public class EnfermedadesServiceImpl implements EnfermedadesService{
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private EnfermedadesRepository enfermedadesRepository;

    @Override
    public EnfermedadesDto crearEnfermedad(EnfermedadesDto enfDto) {
        
        Enfermedades enf = mapearEntidad(enfDto);
        
        Enfermedades nuevaEnf = enfermedadesRepository.save(enf);
        
        EnfermedadesDto respEnfermedad = mapearDto(nuevaEnf);
        
        return respEnfermedad;
        
    }

    @Override
    public List<EnfermedadesDto> listarEnfermedades() {
        List<Enfermedades> enfermedades = enfermedadesRepository.findAll();
        
        return enfermedades.stream().map(enf -> mapearDto(enf)).collect(Collectors.toList());
    }

    @Override
    public EnfermedadesDto obtenerEnfermedadPorId(String codigoenf) {
        
        Enfermedades enfermedad = enfermedadesRepository.findById(codigoenf)
                .orElseThrow(() -> new ResourceNotFoundException("Enfermedad", "id", codigoenf));
        
        return mapearDto(enfermedad);
        
    }

    @Override
    public EnfermedadesDto actualizarEnfermedad(EnfermedadesDto enfDto, String codigoenf) {
        
        Enfermedades enfermedad = enfermedadesRepository.findById(codigoenf)
                .orElseThrow(() -> new ResourceNotFoundException("Enfermedad", "id", codigoenf));
        
        enfermedad.setNombre(enfDto.getNombre());
        enfermedad.setDescripcion(enfDto.getDescripcion());
        
        Enfermedades enfActualizada = enfermedadesRepository.save(enfermedad);
        
        return mapearDto(enfActualizada);
        
    }

    @Override
    public void eliminarEnfermedad(String codigoenf) {
        Enfermedades enfermedad = enfermedadesRepository.findById(codigoenf)
                .orElseThrow(() -> new ResourceNotFoundException("Enfermedad", "id", codigoenf));
        
        enfermedadesRepository.delete(enfermedad);
 
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Enfermedades mapearEntidad(EnfermedadesDto enfDto){
        Enfermedades enf = modelMapper.map(enfDto, Enfermedades.class);
        return enf;
    }
    
    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private EnfermedadesDto mapearDto(Enfermedades enf){
        EnfermedadesDto enfDto = modelMapper.map(enf, EnfermedadesDto.class);
        return enfDto;
    }
    
}
