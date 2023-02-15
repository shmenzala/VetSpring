/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.repository;

import com.pe.sh.Veterinaria.model.Veterinarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author shmen
 */
public interface VeterinariosRepository extends JpaRepository<Veterinarios, String>{
    
    @Query("select count(codigope) from Cliente where codigope=:codigope")
    long coincidenciaPersonaCliente(@Param("codigope") String codigope);
    
}
