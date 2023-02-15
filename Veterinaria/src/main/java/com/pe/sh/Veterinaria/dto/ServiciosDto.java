/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class ServiciosDto {
    
    private String codigoser;
    private String nombreser;
    private String descripser;

    public ServiciosDto() {
    }

    public ServiciosDto(String codigoser, String nombreser, String descripser) {
        this.codigoser = codigoser;
        this.nombreser = nombreser;
        this.descripser = descripser;
    }

    public String getCodigoser() {
        return codigoser;
    }

    public void setCodigoser(String codigoser) {
        this.codigoser = codigoser;
    }

    public String getNombreser() {
        return nombreser;
    }

    public void setNombreser(String nombreser) {
        this.nombreser = nombreser;
    }

    public String getDescripser() {
        return descripser;
    }

    public void setDescripser(String descripser) {
        this.descripser = descripser;
    }
    
    
    
}
