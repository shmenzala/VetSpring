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
@Table(name = "PERSONA")
public class Persona implements Serializable{
    
    
    @Id
    @Column(name = "codigope")
    @GeneratedValue(generator = "inc_seqPer")
    @GenericGenerator(name = "inc_seqPer", strategy = "com.pe.sh.Veterinaria.configuration.StringKeyGenerator",
            parameters = {@Parameter(name = "sqcName", value = "PERSONA_INC"),
                          @Parameter(name = "identificator_id", value = "PE")})
    @SequenceGenerator(name = "inc_seqPer", sequenceName = "PERSONA_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "celular")
    private String celular;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "sexo")
    private int sexo;
    
    @Column(name = "dni")
    private String dni;

    public Persona() {
    }

    public Persona(String id, String nombre, String celular, String telefono, String correo, int sexo, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo = sexo;
        this.dni = dni;
    }

    public String getCodigope() {
        return id;
    }

    public void setCodigope(String id) {
        this.id = id;
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
