/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class VeterinariosDto {
    
    private String codigove;
    private String anio_cont;
    private float salario;

    public VeterinariosDto() {
    }

    public VeterinariosDto(String codigove, String anio_cont, float salario) {
        this.codigove = codigove;
        this.anio_cont = anio_cont;
        this.salario = salario;
    }

    public String getCodigove() {
        return codigove;
    }

    public void setCodigove(String codigove) {
        this.codigove = codigove;
    }

    public String getAnio_cont() {
        return anio_cont;
    }

    public void setAnio_cont(String anio_cont) {
        this.anio_cont = anio_cont;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

}
