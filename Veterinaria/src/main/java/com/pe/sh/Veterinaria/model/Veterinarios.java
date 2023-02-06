/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "VETERINARIOS")
public class Veterinarios implements Serializable{
    
    @Id
    @Column(name = "codigove")
    @GeneratedValue(generator = "inc_seqVet")
    @GenericGenerator(name = "inc_seqVet", strategy = "com.pe.sh.Veterinaria.configuration.StringKeyGenerator",
            parameters = {@Parameter(name = "sqcName", value = "VETERINARIOS_INC"),
                          @Parameter(name = "identificator_id", value = "VE")})
    @SequenceGenerator(name = "inc_seqVet", sequenceName = "VETERINARIOS_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "anio_cont")
    private String anio_cont;
    
    @Column(name = "salario")
    private float salario;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "codigope")
    private Persona persona;

    public Veterinarios() {
    }

    public Veterinarios(String id, String anio_cont, float salario, Persona persona) {
        this.id = id;
        this.anio_cont = anio_cont;
        this.salario = salario;
        this.persona = persona;
    }

    public String getCodigove() {
        return id;
    }

    public void setCodigove(String id) {
        this.id = id;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
}
