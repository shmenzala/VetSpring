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
    
    
    
}
