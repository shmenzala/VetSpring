/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.ServiciosDto;
import com.pe.sh.Veterinaria.exceptions.ResourceNotFoundException;
import com.pe.sh.Veterinaria.model.Servicios;
import com.pe.sh.Veterinaria.repository.ServiciosRepository;
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
public class ServiciosServiceImpl implements ServiciosService{
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private ServiciosRepository serviciosRepository;

    @Override
    public ServiciosDto crearServicio(ServiciosDto serDto) {
        
        Servicios servicio = mapearEntidad(serDto);
        Servicios nuevoServicio = serviciosRepository.save(servicio);
        
        ServiciosDto respServicio = mapearDto(nuevoServicio);
        
        return respServicio;
    }

    @Override
    public List<ServiciosDto> listarServicios() {
        List<Servicios> servicios = serviciosRepository.findAll();
        return servicios.stream().map(servicio -> mapearDto(servicio)).collect(Collectors.toList());
    }

    @Override
    public ServiciosDto obtenerServicioPorId(String id) {
        Servicios servicio = serviciosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio", "id", id));
        return mapearDto(servicio);
    }

    @Override
    public ServiciosDto actualizarServicio(ServiciosDto serDto, String id) {
        Servicios servicio = serviciosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio", "id", id));
        
        servicio.setNombreser(serDto.getNombreser());
        servicio.setDescripser(serDto.getDescripser());
        
        Servicios servicioActualizado = serviciosRepository.save(servicio);
        
        return mapearDto(servicioActualizado);
    }

    @Override
    public void eliminarServicio(String id) {
        Servicios servicio = serviciosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio", "id", id));
       
        serviciosRepository.delete(servicio);
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Servicios mapearEntidad(ServiciosDto serDto) {
        Servicios ser = modelMapper.map(serDto, Servicios.class);
        return ser;
    }

    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private ServiciosDto mapearDto(Servicios ser) {
        ServiciosDto serDto = modelMapper.map(ser, ServiciosDto.class);
        return serDto;
    }
    
}
