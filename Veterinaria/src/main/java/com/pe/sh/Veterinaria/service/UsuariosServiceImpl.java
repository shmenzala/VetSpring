/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.UsuariosDto;
import com.pe.sh.Veterinaria.exceptions.ResourceNotFoundException;
import com.pe.sh.Veterinaria.exceptions.VetAppException;
import com.pe.sh.Veterinaria.model.Roles;
import com.pe.sh.Veterinaria.model.Usuarios;
import com.pe.sh.Veterinaria.model.Veterinarios;
import com.pe.sh.Veterinaria.repository.RolesRepository;
import com.pe.sh.Veterinaria.repository.UsuariosRepository;
import com.pe.sh.Veterinaria.repository.VeterinariosRepository;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    @Autowired
    private RolesRepository rolesRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuariosDto crearUsuario(String codigorol, String codigove, UsuariosDto usuDto) {
        
        if(usuariosRepository.existsByNombreus(usuDto.getNombreus())){
            throw new VetAppException(HttpStatus.BAD_REQUEST, "Ese nombre de usuario ya existe");
        }
        
        //Usuarios usuario = mapearEntidad(usuDto);
        Usuarios usuario = new Usuarios();
        usuario.setNombreus(usuDto.getNombreus());
        usuario.setContraus(passwordEncoder.encode(usuDto.getContraus()));
        
        Veterinarios veterinario = veterinariosRepository.findById(codigove)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario", "id", codigove));
        usuario.setVeterinario(veterinario);

        //Roles rol = rolesRepository.findByNombre("ROLE_ADMIN").get();
        //usuario.setRoles(Collections.singleton(rol));
        
        Roles rol = rolesRepository.findById(codigorol)
                .orElseThrow(() -> new ResourceNotFoundException("Rol", "id", codigorol));
        usuario.setRoles(Collections.singleton(rol));
        
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
        Veterinarios veterinario = veterinariosRepository.findById(codigove)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario", "id", codigove));
        
        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
        
        if(!usuario.getVeterinario().getCodigove().equals(veterinario.getCodigove())){
            throw new VetAppException(HttpStatus.BAD_REQUEST, "El usuario no tiene relacion con el recurso veterinario");
        }
        
        return mapearDto(usuario);
    }

    @Override
    public UsuariosDto actualizarUsuario(UsuariosDto usuDto, String id, String codigove) {
        Veterinarios veterinario = veterinariosRepository.findById(codigove)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario", "id", codigove));
        
        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
        
        if(!usuario.getVeterinario().getCodigove().equals(veterinario.getCodigove())){
            throw new VetAppException(HttpStatus.BAD_REQUEST, "El usuario no tiene relacion con el recurso veterinario");
        }
        
        usuario.setNombreus(usuDto.getNombreus());
        usuario.setContraus(passwordEncoder.encode(usuDto.getContraus()));

        Usuarios usuActualizado = usuariosRepository.save(usuario);
        
        return mapearDto(usuActualizado);
    }

    @Override
    public void eliminarUsuario(String id, String codigove) {
        Veterinarios veterinario = veterinariosRepository.findById(codigove)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario", "id", codigove));
        
        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
        
        if(!usuario.getVeterinario().getCodigove().equals(veterinario.getCodigove())){
            throw new VetAppException(HttpStatus.BAD_REQUEST, "El usuario no tiene relacion con el recurso veterinario");
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
