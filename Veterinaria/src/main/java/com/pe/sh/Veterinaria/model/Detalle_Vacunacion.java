/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pe.sh.Veterinaria.configuration.StringKeyGenerator;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "DETALLE_VACUNACION")
public class Detalle_Vacunacion implements Serializable{
    
    @Id
    @Column(name = "codigodet_vac")
    @GeneratedValue(generator = "inc_seqDvc")
    @GenericGenerator(name = "inc_seqDvc", type = StringKeyGenerator.class,
            parameters = {@Parameter(name = "sqcName", value = "DETALLE_VACUNACION_INC"),
                          @Parameter(name = "identificator_id", value = "DV")})
    @SequenceGenerator(name = "inc_seqDvc", sequenceName = "DETALLE_VACUNACION_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "fecha_ap")
    private String fecha_ap;
    
    @Column(name = "fecha_prog")
    private String fecha_prog;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigocit", nullable = false)
    private Citas codigocitdvfk;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "DETALLE_ENFERMEDADES", joinColumns = @JoinColumn(name = "codigodet_vac", referencedColumnName = "codigodet_vac")
            , inverseJoinColumns = @JoinColumn(name = "codigoenf", referencedColumnName = "codigoenf"))
    private Set<Enfermedades> enfermedades = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "DETALLE_VACUNAS", joinColumns = @JoinColumn(name = "codigodet_vac", referencedColumnName = "codigodet_vac")
            , inverseJoinColumns = @JoinColumn(name = "codigovac", referencedColumnName = "codigovac"))
    private Set<Vacunas> vacunas = new HashSet<>();

    public Detalle_Vacunacion() {
    }

    public Detalle_Vacunacion(String id, String fecha_ap, String fecha_prog, Citas codigocitdvfk) {
        this.id = id;
        this.fecha_ap = fecha_ap;
        this.fecha_prog = fecha_prog;
        this.codigocitdvfk = codigocitdvfk;
    }

    public String getCodigodet_vac() {
        return id;
    }

    public void setCodigodet_vac(String id) {
        this.id = id;
    }

    public String getFecha_ap() {
        return fecha_ap;
    }

    public void setFecha_ap(String fecha_ap) {
        this.fecha_ap = fecha_ap;
    }

    public String getFecha_prog() {
        return fecha_prog;
    }

    public void setFecha_prog(String fecha_prog) {
        this.fecha_prog = fecha_prog;
    }

    public Citas getCodigocit() {
        return codigocitdvfk;
    }

    public void setCodigocit(Citas codigocitdvfk) {
        this.codigocitdvfk = codigocitdvfk;
    }

    public Set<Enfermedades> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Set<Enfermedades> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public Set<Vacunas> getVacunas() {
        return vacunas;
    }

    public void setVacunas(Set<Vacunas> vacunas) {
        this.vacunas = vacunas;
    }
    
}
