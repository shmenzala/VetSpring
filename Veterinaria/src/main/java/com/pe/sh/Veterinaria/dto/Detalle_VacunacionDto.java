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
public class Detalle_VacunacionDto {
    
    private String codigodet_vac;
    private String fecha_ap;
    private String fecha_prog;
    private Set<EnfermedadesDto> enfermedades;
    private Set<VacunasDto> vacunas;

    public Detalle_VacunacionDto() {
    }

    public Detalle_VacunacionDto(String codigodet_vac, String fecha_ap, String fecha_prog) {
        this.codigodet_vac = codigodet_vac;
        this.fecha_ap = fecha_ap;
        this.fecha_prog = fecha_prog;
    }

    public String getCodigodet_vac() {
        return codigodet_vac;
    }

    public void setCodigodet_vac(String codigodet_vac) {
        this.codigodet_vac = codigodet_vac;
    }

    public String getFecha_ap() {
        return fecha_ap;
    }

    public void setFecha_ap(String fecha_ap) {
        this.fecha_ap = fecha_ap;
    }

    public String getFecha_prog() {
        return fecha_prog;
    }

    public void setFecha_prog(String fecha_prog) {
        this.fecha_prog = fecha_prog;
    }

    public Set<EnfermedadesDto> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Set<EnfermedadesDto> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public Set<VacunasDto> getVacunas() {
        return vacunas;
    }

    public void setVacunas(Set<VacunasDto> vacunas) {
        this.vacunas = vacunas;
    }
    
    
    
}
