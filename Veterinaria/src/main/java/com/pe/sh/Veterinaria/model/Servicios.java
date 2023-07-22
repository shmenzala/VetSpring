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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "SERVICIOS")
public class Servicios implements Serializable{
    
    @Id
    @Column(name = "codigoser")
    @GeneratedValue(generator = "inc_seqSer")
    @GenericGenerator(name = "inc_seqSer", type = StringKeyGenerator.class,
            parameters = {@Parameter(name = "sqcName", value = "SERVICIOS_INC"),
                          @Parameter(name = "identificator_id", value = "SV")})
    @SequenceGenerator(name = "inc_seqSer", sequenceName = "SERVICIOS_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "nombreser")
    private String nombreser;
    
    @Column(name = "descripser")
    private String descripser;

    @JsonBackReference
    @OneToMany(mappedBy = "codigoserfk", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Detalle_Servicios> det_serv = new HashSet<>();
    
    public Servicios() {
    }

    public Servicios(String id, String nombreser, String descripser) {
        this.id = id;
        this.nombreser = nombreser;
        this.descripser = descripser;
    }

    public String getCodigoser() {
        return id;
    }

    public void setCodigoser(String id) {
        this.id = id;
    }

    public String getNombreser() {
        return nombreser;
    }

    public void setNombreser(String nombreser) {
        this.nombreser = nombreser;
    }

    public String getDescripser() {
        return descripser;
    }

    public void setDescripser(String descripser) {
        this.descripser = descripser;
    }

    public Set<Detalle_Servicios> getDet_serv() {
        return det_serv;
    }

    public void setDet_serv(Set<Detalle_Servicios> det_serv) {
        this.det_serv = det_serv;
    }
    
}
