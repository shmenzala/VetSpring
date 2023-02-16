/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.Detalle_ServiciosDto;
import com.pe.sh.Veterinaria.model.Detalle_Servicios;
import com.pe.sh.Veterinaria.repository.CitasRepository;
import com.pe.sh.Veterinaria.repository.Detalle_ServiciosRepository;
import com.pe.sh.Veterinaria.repository.ServiciosRepository;
import java.util.List;
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
    private CitasRepository citasRepository;
    
    @Autowired
    private ServiciosRepository serviciosRepository;

    @Override
    public Detalle_ServiciosDto crearDetServ(String codigoser, String codigocit, Detalle_ServiciosDto dsvDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Detalle_ServiciosDto> listarDetServ() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Detalle_ServiciosDto> listarDetServPorIds(String codigoser, String codigocit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Detalle_ServiciosDto obtenerDetServPorId(String codigodet_ser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Detalle_ServiciosDto actualizarDetServ(String codigoser, String codigocit, String codigodet_ser, Detalle_ServiciosDto dsvDto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarDetServPorIds(String codigoser, String codigocit, String codigodet_ser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarDetServ(String codigodet_ser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
