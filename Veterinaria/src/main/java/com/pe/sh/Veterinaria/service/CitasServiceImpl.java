/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.CitasDto;
import com.pe.sh.Veterinaria.model.Citas;
import com.pe.sh.Veterinaria.model.Cliente;
import com.pe.sh.Veterinaria.model.Mascotas;
import com.pe.sh.Veterinaria.model.Veterinarios;
import com.pe.sh.Veterinaria.repository.CitasRepository;
import com.pe.sh.Veterinaria.repository.ClienteRepository;
import com.pe.sh.Veterinaria.repository.MascotasRepository;
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
public class CitasServiceImpl implements CitasService{

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private CitasRepository citasRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private VeterinariosRepository veterinariosRepository;
    
    @Autowired
    private MascotasRepository mascotasRepository;
    
    @Override
    public CitasDto crearCita(String codigocl, String codigove, String codigoma, CitasDto citDto) {
        Citas cita = mapearEntidad(citDto);
        
        Cliente cliente = clienteRepository.findById(codigocl).orElseThrow(null);
        
        Veterinarios veterinario = veterinariosRepository.findById(codigove).orElseThrow(null);
        
        Mascotas mascota = mascotasRepository.findById(codigoma).orElseThrow(null);
        
        cita.setCodigocl(cliente);
        cita.setCodigove(veterinario);
        cita.setCodigoma(mascota);
        
        Citas nuevaCita = citasRepository.save(cita);
        
        return mapearDto(nuevaCita);
    }

    @Override
    public List<CitasDto> listarCitas() {
        List<Citas> citas = citasRepository.findAll();
        return citas.stream().map(cita -> mapearDto(cita)).collect(Collectors.toList());
    }
    
    @Override
    public List<CitasDto> listarCitasPorIds(String codigocl, String codigove, String codigoma) {
        List<Citas> citas = citasRepository.findByCodigoclfkIdAndCodigovefkIdAndCodigomafkId(codigocl, codigove, codigoma);
        
        return citas.stream().map(cit -> mapearDto(cit)).collect(Collectors.toList());
    }

    @Override
    public CitasDto obtenerCitaPorId(String codigocit) {
        Citas cita = citasRepository.findById(codigocit).orElseThrow(null);
        return mapearDto(cita);
    }

    @Override
    public CitasDto actualizarCita(String codigocl, String codigove, String codigoma, String codigocit, CitasDto citDto) {
        
        Cliente cliente = clienteRepository.findById(codigocl).orElseThrow(null);
        
        Veterinarios veterinario = veterinariosRepository.findById(codigove).orElseThrow(null);
        
        Mascotas mascota = mascotasRepository.findById(codigoma).orElseThrow(null);
        
        Citas cita = citasRepository.findById(codigocit).orElseThrow(null); 
        
        if(!(cita.getCodigocl().getCodigocl().equals(cliente.getCodigocl()) && 
           cita.getCodigove().getCodigove().equals(veterinario.getCodigove()) && 
           cita.getCodigoma().getCodigoma().equals(mascota.getCodigoma()))){
            return mapearDto(cita);
        }

        cita.setFecha_cit(citDto.getFecha_cit());
        cita.setDescrip(citDto.getDescrip());
        
        Citas citaActualizada = citasRepository.save(cita);
        
        return mapearDto(citaActualizada);
    }

    @Override
    public void eliminarCitaPorIds(String codigocl, String codigove, String codigoma, String codigocit) {
        Cliente cliente = clienteRepository.findById(codigocl).orElseThrow(null);
        
        Veterinarios veterinario = veterinariosRepository.findById(codigove).orElseThrow(null);
        
        Mascotas mascota = mascotasRepository.findById(codigoma).orElseThrow(null);
        
        Citas cita = citasRepository.findById(codigocit).orElseThrow(null); 
        
        if(!(cita.getCodigocl().getCodigocl().equals(cliente.getCodigocl()) && 
           cita.getCodigove().getCodigove().equals(veterinario.getCodigove()) && 
           cita.getCodigoma().getCodigoma().equals(mascota.getCodigoma()))){
            return ;
        }
        
        citasRepository.delete(cita);
    }

    @Override
    public void eliminarCita(String codigocit) {
        Citas cita = citasRepository.findById(codigocit).orElseThrow(null);
       
        citasRepository.delete(cita);
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Citas mapearEntidad(CitasDto citDto){
        Citas cit = modelMapper.map(citDto, Citas.class);
        return cit;
    }
    
    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private CitasDto mapearDto(Citas cit){
        CitasDto citDto = modelMapper.map(cit, CitasDto.class);
        return citDto;
    }
    
}
