/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "ROLES")
public class Roles implements Serializable{
    
    @Id
    @Column(name = "codigorol")
    @GeneratedValue(generator = "inc_seqRol")
    @GenericGenerator(name = "inc_seqRol", strategy = "com.pe.sh.Veterinaria.configuration.StringKeyGenerator",
            parameters = {@Parameter(name = "sqcName", value = "ROLES_INC"),
                          @Parameter(name = "identificator_id", value = "RL")})
    @SequenceGenerator(name = "inc_seqRol", sequenceName = "ROLES_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Usuarios> usuarios = new HashSet<>();

    public Roles() {
    }

    public Roles(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getCodigorol() {
        return id;
    }

    public void setCodigorol(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
    
}
