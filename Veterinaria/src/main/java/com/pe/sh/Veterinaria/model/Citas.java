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
import jakarta.persistence.ManyToOne;
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
@Table(name = "CITAS")
public class Citas implements Serializable{
    
    @Id
    @Column(name = "codigocit")
    @GeneratedValue(generator = "inc_seqCit")
    @GenericGenerator(name = "inc_seqCit", strategy = "com.pe.sh.Veterinaria.configuration.StringKeyGenerator",
            parameters = {@Parameter(name = "sqcName", value = "CITAS_INC"),
                          @Parameter(name = "identificator_id", value = "CT")})
    @SequenceGenerator(name = "inc_seqCit", sequenceName = "CITAS_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "fecha_cit")
    private String fecha_cit;
    
    @Column(name = "descrip")
    private String descrip;
    //N:1 TABLA CLIENTES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigocl", nullable = false)
    private Cliente codigoclfk;
    //N:1 TABLA VETERINARIOS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigove", nullable = false)
    private Veterinarios codigovefk;
    //N:1 TABLA MASCOTAS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoma", nullable = false)
    private Mascotas codigomafk;
    //1:N TABLA DETALLE_SERVICIOS
    @JsonBackReference
    @OneToMany(mappedBy = "codigocitfk", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Detalle_Servicios> det_serv = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "codigocitdvfk", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Detalle_Vacunacion> det_vac = new HashSet<>();
    
    public Citas() {
    }

    public Citas(String id, String fecha_cit, String descrip, Cliente codigoclfk, Veterinarios codigovefk, Mascotas codigomafk) {
        this.id = id;
        this.fecha_cit = fecha_cit;
        this.descrip = descrip;
        this.codigoclfk = codigoclfk;
        this.codigovefk = codigovefk;
        this.codigomafk = codigomafk;
    }
    
    public String getCodigocit() {
        return id;
    }

    public void setCodigocit(String id) {
        this.id = id;
    }

    public String getFecha_cit() {
        return fecha_cit;
    }

    public void setFecha_cit(String fecha_cit) {
        this.fecha_cit = fecha_cit;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Cliente getCodigocl() {
        return codigoclfk;
    }

    public void setCodigocl(Cliente codigoclfk) {
        this.codigoclfk = codigoclfk;
    }

    public Veterinarios getCodigove() {
        return codigovefk;
    }

    public void setCodigove(Veterinarios codigovefk) {
        this.codigovefk = codigovefk;
    }

    public Mascotas getCodigoma() {
        return codigomafk;
    }

    public void setCodigoma(Mascotas codigomafk) {
        this.codigomafk = codigomafk;
    }

    public Set<Detalle_Servicios> getDet_serv() {
        return det_serv;
    }

    public void setDet_serv(Set<Detalle_Servicios> det_serv) {
        this.det_serv = det_serv;
    }

    public Set<Detalle_Vacunacion> getDet_vac() {
        return det_vac;
    }

    public void setDet_vac(Set<Detalle_Vacunacion> det_vac) {
        this.det_vac = det_vac;
    }

    
    
}
