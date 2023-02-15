/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

import com.pe.sh.Veterinaria.model.Cliente;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author shmen
 */
public class MascotasDto {
    
    private String codigoma;
    private String nombrema;
    private String nombrean;
    private String raza;
    private String color;
    private int sexo;
    private String fecha_na;
    private Set<ClienteDto> clientes;

    public MascotasDto() {
    }

    public MascotasDto(String codigoma, String nombrema, String nombrean, String raza, String color, int sexo, String fecha_na) {
        this.codigoma = codigoma;
        this.nombrema = nombrema;
        this.nombrean = nombrean;
        this.raza = raza;
        this.color = color;
        this.sexo = sexo;
        this.fecha_na = fecha_na;
    }

    public String getCodigoma() {
        return codigoma;
    }

    public void setCodigoma(String codigoma) {
        this.codigoma = codigoma;
    }

    public String getNombrema() {
        return nombrema;
    }

    public void setNombrema(String nombrema) {
        this.nombrema = nombrema;
    }

    public String getNombrean() {
        return nombrean;
    }

    public void setNombrean(String nombrean) {
        this.nombrean = nombrean;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getFecha_na() {
        return fecha_na;
    }

    public void setFecha_na(String fecha_na) {
        this.fecha_na = fecha_na;
    }

    public Set<ClienteDto> getClientes() {
        //return clientes.stream().map(cl -> cl.getCodigocl()).collect(Collectors.toSet());
        return clientes;
    }

    public void setClientes(Set<ClienteDto> clientes) {
        this.clientes = clientes;
    }
    
    
    
}
