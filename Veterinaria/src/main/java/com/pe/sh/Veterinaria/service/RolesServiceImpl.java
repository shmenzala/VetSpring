/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.RolesDto;
import com.pe.sh.Veterinaria.exceptions.ResourceNotFoundException;
import com.pe.sh.Veterinaria.model.Roles;
import com.pe.sh.Veterinaria.repository.RolesRepository;
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
public class RolesServiceImpl implements RolesService{
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public RolesDto crearRol(RolesDto rolDto) {
        Roles rol = mapearEntidad(rolDto);
        
        Roles nuevoRol = rolesRepository.save(rol);
        
        RolesDto respRol = mapearDto(nuevoRol);
        
        return respRol;
    }

    @Override
    public List<RolesDto> listarRoles() {
        List<Roles> roles = rolesRepository.findAll();
        
        return roles.stream().map(rol -> mapearDto(rol)).collect(Collectors.toList());
    }

    @Override
    public RolesDto obtenerRolesPorId(String codigorol) {
        Roles rol = rolesRepository.findById(codigorol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id", codigorol));
        
        return mapearDto(rol);
    }

    @Override
    public RolesDto actualizarRol(RolesDto rolDto, String codigorol) {
        Roles rol = rolesRepository.findById(codigorol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id", codigorol));
        
        rol.setNombre(rolDto.getNombre());
        
        Roles rolActualizado = rolesRepository.save(rol);
        
        return mapearDto(rolActualizado);
    }

    @Override
    public void eliminarRol(String codigorol) {
        Roles rol = rolesRepository.findById(codigorol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id", codigorol));
        
        rolesRepository.delete(rol);
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Roles mapearEntidad(RolesDto rolDto){
        Roles rol = modelMapper.map(rolDto, Roles.class);
        return rol;
    }
    
    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private RolesDto mapearDto(Roles rol){
        RolesDto rolDto = modelMapper.map(rol, RolesDto.class);
        return rolDto;
    }
    
}
