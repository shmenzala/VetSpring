/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.repository;

import com.pe.sh.Veterinaria.model.Detalle_Vacunacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author shmen
 */
public interface Detalle_VacunacionRepository extends JpaRepository<Detalle_Vacunacion, String>{
    
    List<Detalle_Vacunacion> findByCodigocitdvfkId(String codigocit);
    
}
