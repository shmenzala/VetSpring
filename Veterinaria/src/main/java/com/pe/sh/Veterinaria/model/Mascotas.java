/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "MASCOTAS")
public class Mascotas {
    
    @Id
    @Column(name = "codigoma")
    @GeneratedValue(generator = "inc_seqMas")
    @GenericGenerator(name = "inc_seqMas", strategy = "com.pe.sh.Veterinaria.configuration.StringKeyGenerator",
            parameters = {@Parameter(name = "sqcName", value = "MASCOTAS_INC"),
                          @Parameter(name = "identificator_id", value = "MA")})
    @SequenceGenerator(name = "inc_seqMas", sequenceName = "MASCOTAS_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "nombrema")
    private String nombrema;
    
    @Column(name = "nombrean")
    private String nombrean;
    
    @Column(name = "raza")
    private String raza;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "sexo")
    private int sexo;
    
    @Column(name = "fecha_na")
    private String fecha_na;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "DETALLE_PROPIETARIO", joinColumns = @JoinColumn(name = "codigoma")
            , inverseJoinColumns = @JoinColumn(name = "codigocl"))
    private Set<Cliente> clientes = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "codigomafk", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Citas> citas = new HashSet<>();
    
    public Mascotas() {
    }

    public Mascotas(String id, String nombrema, String nombrean, String raza, String color, int sexo, String fecha_na) {
        this.id = id;
        this.nombrema = nombrema;
        this.nombrean = nombrean;
        this.raza = raza;
        this.color = color;
        this.sexo = sexo;
        this.fecha_na = fecha_na;
    }

    public String getCodigoma() {
        return id;
    }

    public void setCodigoma(String id) {
        this.id = id;
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

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Set<Citas> getCitas() {
        return citas;
    }

    public void setCitas(Set<Citas> citas) {
        this.citas = citas;
    }
    
    
    
}
