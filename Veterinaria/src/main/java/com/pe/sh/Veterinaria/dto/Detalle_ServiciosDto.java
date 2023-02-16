/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class Detalle_ServiciosDto {
    
    private String codigodet_ser;
    private String descrip;

    public Detalle_ServiciosDto() {
    }

    public Detalle_ServiciosDto(String codigodet_ser, String descrip) {
        this.codigodet_ser = codigodet_ser;
        this.descrip = descrip;
    }

    public String getCodigodet_ser() {
        return codigodet_ser;
    }

    public void setCodigodet_ser(String codigodet_ser) {
        this.codigodet_ser = codigodet_ser;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    
    
    
}
