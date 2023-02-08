/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.UsuariosDto;
import com.pe.sh.Veterinaria.model.Usuarios;
import com.pe.sh.Veterinaria.model.Veterinarios;
import com.pe.sh.Veterinaria.repository.UsuariosRepository;
import com.pe.sh.Veterinaria.repository.VeterinariosRepository;
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
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private VeterinariosRepository veterinariosRepository;

    @Override
    public UsuariosDto crearUsuario(String codigove, UsuariosDto usuDto) {
        Usuarios usuario = mapearEntidad(usuDto);
        
        Veterinarios veterinario = veterinariosRepository.findById(codigove).orElseThrow(null);
        usuario.setVeterinario(veterinario);
        
        Usuarios nuevoUsuario = usuariosRepository.save(usuario);

        return mapearDto(nuevoUsuario);
    }

    @Override
    public List<UsuariosDto> listarUsuarios() {
        List<Usuarios> usuarios = usuariosRepository.findAll();
        return usuarios.stream().map(usuario -> mapearDto(usuario)).collect(Collectors.toList());
    }

    @Override
    public UsuariosDto obtenerUsuarioPorId(String id, String codigove) {
        Veterinarios veterinario = veterinariosRepository.findById(codigove).orElseThrow(null);
        
        Usuarios usuario = usuariosRepository.findById(id).orElseThrow(null);
        
        if(!usuario.getVeterinario().getCodigove().equals(veterinario.getCodigove())){
            return mapearDto(usuario);
        }
        
        return mapearDto(usuario);
    }

    @Override
    public UsuariosDto actualizarUsuario(UsuariosDto usuDto, String id, String codigove) {
        Veterinarios veterinario = veterinariosRepository.findById(codigove).orElseThrow(null);
        
        Usuarios usuario = usuariosRepository.findById(id).orElseThrow(null);
        
        if(!usuario.getVeterinario().getCodigove().equals(veterinario.getCodigove())){
            return mapearDto(usuario);
        }
        
        usuario.setNombreus(usuDto.getNombreus());
        usuario.setContraus(usuDto.getContraus());

        Usuarios usuActualizado = usuariosRepository.save(usuario);
        
        return mapearDto(usuActualizado);
    }

    @Override
    public void eliminarUsuario(String id, String codigove) {
        Veterinarios veterinario = veterinariosRepository.findById(codigove).orElseThrow(null);
        
        Usuarios usuario = usuariosRepository.findById(id).orElseThrow(null);
        
        if(!usuario.getVeterinario().getCodigove().equals(veterinario.getCodigove())){
            return ;
        }
        
        usuariosRepository.delete(usuario);
    }
    
     //La ENTIDAD setea los datos provenientes del DTO
    private Usuarios mapearEntidad(UsuariosDto usuDto){
        Usuarios usu = modelMapper.map(usuDto, Usuarios.class);
        return usu;
    }
    
    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private UsuariosDto mapearDto(Usuarios usu){
        UsuariosDto usuDto = modelMapper.map(usu, UsuariosDto.class);
        return usuDto;
    }
    
}
