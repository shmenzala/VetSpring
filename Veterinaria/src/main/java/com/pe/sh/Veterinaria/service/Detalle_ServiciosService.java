/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.Detalle_ServiciosDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface Detalle_ServiciosService {
    
    public Detalle_ServiciosDto crearDetServ(String codigoser, String codigocit, Detalle_ServiciosDto dsvDto);
    
    public List<Detalle_ServiciosDto> listarDetServ();
    
    public List<Detalle_ServiciosDto> listarDetServPorIds(String codigoser, String codigocit);
    
    public Detalle_ServiciosDto obtenerDetServPorId(String codigodet_ser);
    
    public Detalle_ServiciosDto actualizarDetServ(String codigoser, String codigocit, String codigodet_ser, Detalle_ServiciosDto dsvDto);
    
    public void eliminarDetServPorIds(String codigoser, String codigocit, String codigodet_ser);
    
    public void eliminarDetServ(String codigodet_ser);
    
}
