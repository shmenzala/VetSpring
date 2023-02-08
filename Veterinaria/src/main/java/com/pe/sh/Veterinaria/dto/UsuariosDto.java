/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class UsuariosDto {
    
    private String codigous;
    private String nombreus;
    private String contraus;

    public UsuariosDto() {
    }

    public UsuariosDto(String codigous, String nombreus, String contraus) {
        this.codigous = codigous;
        this.nombreus = nombreus;
        this.contraus = contraus;
    }

    public String getCodigous() {
        return codigous;
    }

    public void setCodigous(String codigous) {
        this.codigous = codigous;
    }

    public String getNombreus() {
        return nombreus;
    }

    public void setNombreus(String nombreus) {
        this.nombreus = nombreus;
    }

    public String getContraus() {
        return contraus;
    }

    public void setContraus(String contraus) {
        this.contraus = contraus;
    }
    
}
