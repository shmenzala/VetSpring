/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.Detalle_VacunacionDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface Detalle_VacunacionService {
    
    public Detalle_VacunacionDto crearDetVac(Detalle_VacunacionDto dtvDto, String codigocit);
    
    public List<Detalle_VacunacionDto> listarDetVacs();
    
    public Detalle_VacunacionDto obtenerDetVacPorId(String codigodet_vac);
    
    public Detalle_VacunacionDto actualizarDetVac(Detalle_VacunacionDto dtvDto, String codigodet_vac);
    
    public void eliminarDetVac(String codigodet_vac);
    
    public List<Detalle_VacunacionDto> listarDetVacsPorCitaId(String codigocit);
    
    public Detalle_VacunacionDto asignarEnfermedadALaDetVac(String codigodet_vac, String codigoenf);
    
    public Detalle_VacunacionDto asignarVacunaALaDetVac(String codigodet_vac, String codigovac);
    
}
