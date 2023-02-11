/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.MascotasDto;
import com.pe.sh.Veterinaria.model.Cliente;
import com.pe.sh.Veterinaria.model.Mascotas;
import com.pe.sh.Veterinaria.repository.ClienteRepository;
import com.pe.sh.Veterinaria.repository.MascotasRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class MascotasServiceImpl implements MascotasService{

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private MascotasRepository mascotasRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public MascotasDto crearMascota(MascotasDto masDto) {
        Mascotas mascota = mapearEntidad(masDto);
        Mascotas nuevaMascota = mascotasRepository.save(mascota);
        
        MascotasDto respMascota = mapearDto(nuevaMascota);
        
        return respMascota;
    }

    @Override
    public List<MascotasDto> listarMascotas() {
        List<Mascotas> mascotas = mascotasRepository.findAll();
        return mascotas.stream().map(mascota -> mapearDto(mascota)).collect(Collectors.toList());
    }

    @Override
    public MascotasDto obtenerMascotaPorId(String id) {
        Mascotas mascota = mascotasRepository.findById(id).orElseThrow(null);
        return mapearDto(mascota);
    }

    @Override
    public MascotasDto actualizarMascota(MascotasDto masDto, String id) {
        Mascotas mascota = mascotasRepository.findById(id).orElseThrow(null);
        
        mascota.setNombrema(masDto.getNombrema());
        mascota.setNombrean(masDto.getNombrean());
        mascota.setRaza(masDto.getRaza());
        mascota.setColor(masDto.getColor());
        mascota.setSexo(masDto.getSexo());
        mascota.setFecha_na(masDto.getFecha_na());
        
        Mascotas mascotaActualizada = mascotasRepository.save(mascota);
        
        return mapearDto(mascotaActualizada);
    }

    @Override
    public void eliminarMascota(String id) {
        Mascotas mascota = mascotasRepository.findById(id).orElseThrow(null);
       
        mascotasRepository.delete(mascota);
    }
    
    @Override
    public List<MascotasDto> listarMascotasPorClienteId(String clienteid) {
        List<Mascotas> mascotas = mascotasRepository.findByClientesId(clienteid);
        return mascotas.stream().map(mascota -> mapearDto(mascota)).collect(Collectors.toList());
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Mascotas mapearEntidad(MascotasDto masDto){
        Mascotas mas = modelMapper.map(masDto, Mascotas.class);
        return mas;
    }
    
    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private MascotasDto mapearDto(Mascotas mas){
        MascotasDto masDto = modelMapper.map(mas, MascotasDto.class);
        return masDto;
    }

    

    
    
}
