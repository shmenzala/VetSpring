/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class ClienteDto {
    
    private String codigocl;
    private String direccion;

    public ClienteDto() {
    }

    public ClienteDto(String codigocl, String direccion) {
        this.codigocl = codigocl;
        this.direccion = direccion;
    }

    public String getCodigocl() {
        return codigocl;
    }

    public void setCodigocl(String codigocl) {
        this.codigocl = codigocl;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
