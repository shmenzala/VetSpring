/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.MascotasDto;
import com.pe.sh.Veterinaria.model.Mascotas;
import com.pe.sh.Veterinaria.repository.MascotasRepository;
import java.util.List;
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
    
    @Override
    public MascotasDto crearMascota(MascotasDto masDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MascotasDto> listarMascotas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MascotasDto obtenerMascotaPorId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MascotasDto actualizarMascota(MascotasDto masDto, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarMascota(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
