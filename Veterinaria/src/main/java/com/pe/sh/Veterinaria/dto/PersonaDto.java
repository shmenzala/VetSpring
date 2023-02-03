/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class PersonaDto {
    
    private String codigope;
    private String nombre;
    private String celular;
    private String telefono;
    private String correo;
    private int sexo;
    private String dni;

    public PersonaDto() {
    }

    public PersonaDto(String codigope, String nombre, String celular, String telefono, String correo, int sexo, String dni) {
        this.codigope = codigope;
        this.nombre = nombre;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo = sexo;
        this.dni = dni;
    }

    public String getCodigope() {
        return codigope;
    }

    public void setCodigope(String codigope) {
        this.codigope = codigope;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
}
