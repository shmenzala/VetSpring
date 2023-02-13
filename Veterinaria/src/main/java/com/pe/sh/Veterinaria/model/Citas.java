/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigocl", nullable = false)
    private Cliente codigoclfk;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigove", nullable = false)
    private Veterinarios codigovefk;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoma", nullable = false)
    private Mascotas codigomafk;

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

}
