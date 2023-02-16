/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.Detalle_ServiciosDto;
import com.pe.sh.Veterinaria.model.Citas;
import com.pe.sh.Veterinaria.model.Detalle_Servicios;
import com.pe.sh.Veterinaria.model.Servicios;
import com.pe.sh.Veterinaria.repository.CitasRepository;
import com.pe.sh.Veterinaria.repository.Detalle_ServiciosRepository;
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
public class Detalle_ServiciosServiceImpl implements Detalle_ServiciosService{
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private Detalle_ServiciosRepository detalle_ServiciosRepository;
    
    @Autowired
    private ServiciosRepository serviciosRepository;
    
    @Autowired
    private CitasRepository citasRepository;

    @Override
    public Detalle_ServiciosDto crearDetServ(String codigoser, String codigocit, Detalle_ServiciosDto dsvDto) {
        Detalle_Servicios detServ = mapearEntidad(dsvDto);
        
        Servicios servicio = serviciosRepository.findById(codigoser).orElseThrow(null);
        
        Citas cita = citasRepository.findById(codigocit).orElseThrow(null);
        
        detServ.setCodigoser(servicio);
        detServ.setCodigocit(cita);
        
        Detalle_Servicios nuevodetServ = detalle_ServiciosRepository.save(detServ);
        
        return mapearDto(nuevodetServ);
    }

    @Override
    public List<Detalle_ServiciosDto> listarDetServ() {
        List<Detalle_Servicios> detServs = detalle_ServiciosRepository.findAll();
        return detServs.stream().map(detServ -> mapearDto(detServ)).collect(Collectors.toList());
    }

    @Override
    public List<Detalle_ServiciosDto> listarDetServPorIds(String codigoser, String codigocit) {
        List<Detalle_Servicios> detServs = detalle_ServiciosRepository.findByCodigoserfkIdAndCodigocitfkId(codigoser, codigocit);
        return detServs.stream().map(detSv -> mapearDto(detSv)).collect(Collectors.toList());        
    }

    @Override
    public Detalle_ServiciosDto obtenerDetServPorId(String codigodet_ser) {
        Detalle_Servicios detServs = detalle_ServiciosRepository.findById(codigodet_ser).orElseThrow(null);
        return mapearDto(detServs);
    }

    @Override
    public Detalle_ServiciosDto actualizarDetServ(String codigoser, String codigocit, String codigodet_ser, Detalle_ServiciosDto dsvDto) {
        Detalle_Servicios detServs = detalle_ServiciosRepository.findById(codigodet_ser).orElseThrow(null);
        
        Servicios servicio = serviciosRepository.findById(codigoser).orElseThrow(null);
        
        Citas cita = citasRepository.findById(codigocit).orElseThrow(null);
        
        if(!(detServs.getCodigoser().getCodigoser().equals(servicio.getCodigoser()) &&
           detServs.getCodigocit().getCodigocit().equals(cita.getCodigocit()))){
            return mapearDto(detServs);
        }
        
        detServs.setDescrip(dsvDto.getDescrip());
        
        Detalle_Servicios detServsActualizada = detalle_ServiciosRepository.save(detServs);
        
        return mapearDto(detServsActualizada);
        
    }

    @Override
    public void eliminarDetServPorIds(String codigoser, String codigocit, String codigodet_ser) {
        Detalle_Servicios detServs = detalle_ServiciosRepository.findById(codigodet_ser).orElseThrow(null);
        
        Servicios servicio = serviciosRepository.findById(codigoser).orElseThrow(null);
        
        Citas cita = citasRepository.findById(codigocit).orElseThrow(null);
        
        if(!(detServs.getCodigoser().getCodigoser().equals(servicio.getCodigoser()) &&
           detServs.getCodigocit().getCodigocit().equals(cita.getCodigocit()))){
            return ;
        }
        
        detalle_ServiciosRepository.delete(detServs);
    }

    @Override
    public void eliminarDetServ(String codigodet_ser) {
        Detalle_Servicios detServs = detalle_ServiciosRepository.findById(codigodet_ser).orElseThrow(null);
        detalle_ServiciosRepository.delete(detServs);
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Detalle_Servicios mapearEntidad(Detalle_ServiciosDto dsvDto) {
        Detalle_Servicios dsv = modelMapper.map(dsvDto, Detalle_Servicios.class);
        return dsv;
    }

    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private Detalle_ServiciosDto mapearDto(Detalle_Servicios dsv) {
        Detalle_ServiciosDto dsvDto = modelMapper.map(dsv, Detalle_ServiciosDto.class);
        return dsvDto;
    }
    
    
}
