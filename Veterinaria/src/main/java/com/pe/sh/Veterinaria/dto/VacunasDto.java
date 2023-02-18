/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class VacunasDto {
    
    private String codigovac;
    private String nombre;
    private String descripcion;

    public VacunasDto() {
    }

    public VacunasDto(String codigovac, String nombre, String descripcion) {
        this.codigovac = codigovac;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCodigovac() {
        return codigovac;
    }

    public void setCodigovac(String codigovac) {
        this.codigovac = codigovac;
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
