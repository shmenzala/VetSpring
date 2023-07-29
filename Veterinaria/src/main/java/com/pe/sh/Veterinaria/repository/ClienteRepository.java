/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.repository;

import com.pe.sh.Veterinaria.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author shmen
 */
public interface ClienteRepository extends JpaRepository<Cliente, String>{
    
    //List<Cliente> findByPersonacliId(String personacliId);
    
    List<Cliente> findByMascotasId(String codigoma);
    
    @Query(value = "select count(codigope) from Veterinarios where codigope=:codigope", nativeQuery = true)
    long coincidenciaPersonaVeterinario(@Param("codigope") String codigope);
    
}
