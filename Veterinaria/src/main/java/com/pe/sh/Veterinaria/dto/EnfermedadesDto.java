/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class EnfermedadesDto {
    
    private String codigoenf;
    private String nombre;
    private String descripcion;

    public EnfermedadesDto() {
    }

    public EnfermedadesDto(String codigoenf, String nombre, String descripcion) {
        this.codigoenf = codigoenf;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCodigoenf() {
        return codigoenf;
    }

    public void setCodigoenf(String codigoenf) {
        this.codigoenf = codigoenf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
