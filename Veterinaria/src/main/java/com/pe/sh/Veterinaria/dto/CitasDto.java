/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

import java.util.Set;

/**
 *
 * @author shmen
 */
public class CitasDto {
    
    private String codigocit;
    private String fecha_cit;
    private String descrip;
    private Set<Detalle_ServiciosDto> det_serv;
    private Set<Detalle_VacunacionDto> det_vac;

    public CitasDto() {
    }

    public CitasDto(String codigocit, String fecha_cit, String descrip) {
        this.codigocit = codigocit;
        this.fecha_cit = fecha_cit;
        this.descrip = descrip;
    }

    public String getCodigocit() {
        return codigocit;
    }

    public void setCodigocit(String codigocit) {
        this.codigocit = codigocit;
    }

    public String getFecha_cit() {
        return fecha_cit;
    }

    public void setFecha_cit(String fecha_cit) {
        this.fecha_cit = fecha_cit;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Set<Detalle_ServiciosDto> getDet_serv() {
        return det_serv;
    }

    public void setDet_serv(Set<Detalle_ServiciosDto> det_serv) {
        this.det_serv = det_serv;
    }

    public Set<Detalle_VacunacionDto> getDet_vac() {
        return det_vac;
    }

    public void setDet_vac(Set<Detalle_VacunacionDto> det_vac) {
        this.det_vac = det_vac;
    }
    
}
