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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "USUARIOS")
public class Usuarios implements UserDetails {

    @Id
    @Column(name = "codigous")
    @GeneratedValue(generator = "inc_seqUsu")
    @GenericGenerator(name = "inc_seqUsu", type = StringKeyGenerator.class,
            parameters = {
                @Parameter(name = "sqcName", value = "USUARIOS_INC"),
                @Parameter(name = "identificator_id", value = "US")})
    @SequenceGenerator(name = "inc_seqUsu", sequenceName = "USUARIOS_INC", initialValue = 1, allocationSize = 1)
    private String id;

    @Column(name = "nombreus")
    private String nombreus;

    @Column(name = "contraus")
    private String contraus;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "codigove")
    private Veterinarios veterinario;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "USUARIOS_ROLES", joinColumns = @JoinColumn(name = "codigous", referencedColumnName = "codigous"),
            inverseJoinColumns = @JoinColumn(name = "codigorol", referencedColumnName = "codigorol"))
    private Set<Roles> roles = new HashSet<>();

    public Usuarios() {
    }

    public Usuarios(String id, String nombreus, String contraus, Veterinarios veterinario) {
        this.id = id;
        this.nombreus = nombreus;
        this.contraus = contraus;
        this.veterinario = veterinario;
    }

    public String getCodigous() {
        return id;
    }

    public void setCodigous(String id) {
        this.id = id;
    }

    public String getNombreus() {
        return nombreus;
    }

    public void setNombreus(String nombreus) {
        this.nombreus = nombreus;
    }

    public String getContraus() {
        return contraus;
    }

    public void setContraus(String contraus) {
        this.contraus = contraus;
    }

    public Veterinarios getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinarios veterinario) {
        this.veterinario = veterinario;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (var r : this.roles) {
            var sga = new SimpleGrantedAuthority(r.getNombre());
            authorities.add(sga);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return contraus;
    }

    @Override
    public String getUsername() {
        return nombreus;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
