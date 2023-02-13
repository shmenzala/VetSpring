/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class CitasDto {
    
    private String codigocit;
    private String fecha_cit;
    private String descrip;

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
    
    
    
}
