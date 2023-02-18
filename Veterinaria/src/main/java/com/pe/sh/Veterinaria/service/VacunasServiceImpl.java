/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.VacunasDto;
import com.pe.sh.Veterinaria.model.Vacunas;
import com.pe.sh.Veterinaria.repository.VacunasRepository;
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
public class VacunasServiceImpl implements VacunasService{

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private VacunasRepository vacunasRepository;
    
    @Override
    public VacunasDto crearVacunas(VacunasDto vacDto) {
        
        Vacunas vacuna = mapearEntidad(vacDto);
        
        Vacunas nuevaVac = vacunasRepository.save(vacuna);
        
        VacunasDto respVacuna = mapearDto(nuevaVac);
        
        return respVacuna;
        
    }

    @Override
    public List<VacunasDto> listarVacunas() {
        List<Vacunas> vacunas = vacunasRepository.findAll();
        
        return vacunas.stream().map(vac -> mapearDto(vac)).collect(Collectors.toList());
    }

    @Override
    public VacunasDto obtenerVacunasPorId(String codigovac) {
        Vacunas vacuna = vacunasRepository.findById(codigovac).orElseThrow(null);
        
        return mapearDto(vacuna);
    }

    @Override
    public VacunasDto actualizarVacunas(VacunasDto vacDto, String codigovac) {
        Vacunas vacuna = vacunasRepository.findById(codigovac).orElseThrow(null);
        
        vacuna.setNombre(vacDto.getNombre());
        vacuna.setDescripcion(vacDto.getDescripcion());
        
        Vacunas vacActualizada = vacunasRepository.save(vacuna);
        
        return mapearDto(vacActualizada);
    }

    @Override
    public void eliminarVacunas(String codigovac) {
        Vacunas vacuna = vacunasRepository.findById(codigovac).orElseThrow(null);
        
        vacunasRepository.delete(vacuna);
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Vacunas mapearEntidad(VacunasDto vacDto){
        Vacunas vac = modelMapper.map(vacDto, Vacunas.class);
        return vac;
    }
    
    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private VacunasDto mapearDto(Vacunas vac){
        VacunasDto vacDto = modelMapper.map(vac, VacunasDto.class);
        return vacDto;
    }
    
}
