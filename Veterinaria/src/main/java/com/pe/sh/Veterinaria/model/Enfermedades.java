/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import com.pe.sh.Veterinaria.configuration.StringKeyGenerator;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "ENFERMEDADES")
public class Enfermedades implements Serializable{
    
    @Id
    @Column(name = "codigoenf")
    @GeneratedValue(generator = "inc_seqEnf")
    @GenericGenerator(name = "inc_seqEnf", type = StringKeyGenerator.class,
            parameters = {@Parameter(name = "sqcName", value = "ENFERMEDADES_INC"),
                          @Parameter(name = "identificator_id", value = "EF")})
    @SequenceGenerator(name = "inc_seqEnf", sequenceName = "ENFERMEDADES_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToMany(mappedBy = "enfermedades", fetch = FetchType.LAZY)
    private Set<Detalle_Vacunacion> detalle_vacunacion = new HashSet<>();

    public Enfermedades() {
    }

    public Enfermedades(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCodigoenf() {
        return id;
    }

    public void setCodigoenf(String id) {
        this.id = id;
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

    public Set<Detalle_Vacunacion> getDetalle_vacunacion() {
        return detalle_vacunacion;
    }

    public void setDetalle_vacunacion(Set<Detalle_Vacunacion> detalle_vacunacion) {
        this.detalle_vacunacion = detalle_vacunacion;
    }
    
}
