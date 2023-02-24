/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.repository;

import com.pe.sh.Veterinaria.model.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author shmen
 */
public interface UsuariosRepository extends JpaRepository<Usuarios, String>{
    
    public Optional<Usuarios> findByNombreus(String nombreus);
    
    public Boolean existsByNombreus(String nombreus);
    
}
