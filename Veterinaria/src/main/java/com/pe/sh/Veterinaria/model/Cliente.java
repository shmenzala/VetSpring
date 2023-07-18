/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
    
    @Id
    @Column(name = "codigocl")
    @GeneratedValue(generator = "inc_seqCli")
    @GenericGenerator(name = "inc_seqCli", strategy = "com.pe.sh.Veterinaria.configuration.StringKeyGenerator",
            parameters = {@Parameter(name = "sqcName", value = "CLIENTE_INC"),
                          @Parameter(name = "identificator_id", value = "CL")})
    @SequenceGenerator(name = "inc_seqCli", sequenceName = "CLIENTE_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "direccion")
    private String direccion;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "codigope")
    private Persona personacli;
    
    @ManyToMany(mappedBy = "clientes", fetch = FetchType.LAZY)
    private Set<Mascotas> mascotas = new HashSet<>();
    
    @JsonBackReference
    @OneToMany(mappedBy = "codigoclfk", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Citas> citas = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String id, String direccion, Persona personacli) {
        this.id = id;
        this.direccion = direccion;
        this.personacli = personacli;
    }

    public String getCodigocl() {
        return id;
    }

    public void setCodigocl(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Persona getPersonacli() {
        return personacli;
    }

    public void setPersonacli(Persona personacli) {
        this.personacli = personacli;
    }

    public Set<Mascotas> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Set<Mascotas> mascotas) {
        this.mascotas = mascotas;
    }

    public Set<Citas> getCitas() {
        return citas;
    }

    public void setCitas(Set<Citas> citas) {
        this.citas = citas;
    }
    
    
    
}
