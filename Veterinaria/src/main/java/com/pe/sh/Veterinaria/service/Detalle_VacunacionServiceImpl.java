/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.Detalle_VacunacionDto;
import com.pe.sh.Veterinaria.exceptions.ResourceNotFoundException;
import com.pe.sh.Veterinaria.model.Citas;
import com.pe.sh.Veterinaria.model.Detalle_Vacunacion;
import com.pe.sh.Veterinaria.model.Enfermedades;
import com.pe.sh.Veterinaria.model.Vacunas;
import com.pe.sh.Veterinaria.repository.CitasRepository;
import com.pe.sh.Veterinaria.repository.Detalle_VacunacionRepository;
import com.pe.sh.Veterinaria.repository.EnfermedadesRepository;
import com.pe.sh.Veterinaria.repository.VacunasRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shmen
 */
@Service
public class Detalle_VacunacionServiceImpl implements Detalle_VacunacionService{
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private Detalle_VacunacionRepository detalle_VacunacionRepository;
    
    @Autowired
    private CitasRepository citasRepository;
    
    @Autowired
    private EnfermedadesRepository enfermedadesRepository;
    
    @Autowired
    private VacunasRepository vacunasRepository;

    @Override
    public Detalle_VacunacionDto crearDetVac(Detalle_VacunacionDto dtvDto, String codigocit) {
        
        Detalle_Vacunacion detVac = mapearEntidad(dtvDto);
        
        Citas cita = citasRepository.findById(codigocit)
                .orElseThrow(() -> new ResourceNotFoundException("Cita", "id", codigocit));
        
        detVac.setCodigocit(cita);
        
        Detalle_Vacunacion detVacNuevo = detalle_VacunacionRepository.save(detVac);
        
        return mapearDto(detVacNuevo);
        
    }

    @Override
    public List<Detalle_VacunacionDto> listarDetVacs() {
        
        List<Detalle_Vacunacion> detVacs = detalle_VacunacionRepository.findAll();
        return detVacs.stream().map(detVac -> mapearDto(detVac)).collect(Collectors.toList());
        
    }

    @Override
    public Detalle_VacunacionDto obtenerDetVacPorId(String codigodet_vac) {
        
        Detalle_Vacunacion detVac = detalle_VacunacionRepository.findById(codigodet_vac)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle_Vacunacion", "id", codigodet_vac));
        return mapearDto(detVac);
        
    }

    @Override
    public Detalle_VacunacionDto actualizarDetVac(Detalle_VacunacionDto dtvDto, String codigodet_vac) {
        Detalle_Vacunacion detVac = detalle_VacunacionRepository.findById(codigodet_vac)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle_Vacunacion", "id", codigodet_vac));
        
        detVac.setFecha_ap(dtvDto.getFecha_ap());
        detVac.setFecha_prog(dtvDto.getFecha_prog());
        
        Detalle_Vacunacion detVacActualizado = detalle_VacunacionRepository.save(detVac);
        
        return mapearDto(detVacActualizado);
        
    }
    
    @Override
    public List<Detalle_VacunacionDto> listarDetVacsPorCitaId(String codigocit) {
        
        List<Detalle_Vacunacion> detVacs = detalle_VacunacionRepository.findByCodigocitdvfkId(codigocit);
        return detVacs.stream().map(detVac -> mapearDto(detVac)).collect(Collectors.toList());
        
    }

    @Override
    public Detalle_VacunacionDto asignarEnfermedadALaDetVac(String codigodet_vac, String codigoenf) {
        
        Set<Enfermedades> enfermedadSet = null;
        
        Detalle_Vacunacion detVac = detalle_VacunacionRepository.findById(codigodet_vac)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle_Vacunacion", "id", codigodet_vac));
        
        Enfermedades enfermedad = enfermedadesRepository.findById(codigoenf)
                .orElseThrow(() -> new ResourceNotFoundException("Enfermedad", "id", codigoenf));
        
        enfermedadSet = detVac.getEnfermedades();
        enfermedadSet.add(enfermedad);
        
        detVac.setEnfermedades(enfermedadSet);
        
        Detalle_Vacunacion detVacActualizadaEnf = detalle_VacunacionRepository.save(detVac);
        
        return mapearDto(detVacActualizadaEnf);
        
    }

    @Override
    public Detalle_VacunacionDto asignarVacunaALaDetVac(String codigodet_vac, String codigovac) {
        Set<Vacunas> vacunaSet = null;
        
        Detalle_Vacunacion detVac = detalle_VacunacionRepository.findById(codigodet_vac)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle_Vacunacion", "id", codigodet_vac));
        
        Vacunas vacuna = vacunasRepository.findById(codigovac)
                .orElseThrow(() -> new ResourceNotFoundException("Vacuna", "id", codigovac));
        
        vacunaSet = detVac.getVacunas();
        vacunaSet.add(vacuna);
        
        detVac.setVacunas(vacunaSet);
        
        Detalle_Vacunacion detVacActualizadaVac = detalle_VacunacionRepository.save(detVac);
        
        return mapearDto(detVacActualizadaVac);
    }

    @Override
    public void eliminarDetVac(String codigodet_vac) {
        Detalle_Vacunacion detVac = detalle_VacunacionRepository.findById(codigodet_vac)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle_Vacunacion", "id", codigodet_vac));
        detalle_VacunacionRepository.delete(detVac);
    }
    
    //La ENTIDAD setea los datos provenientes del DTO
    private Detalle_Vacunacion mapearEntidad(Detalle_VacunacionDto dtvDto) {
        Detalle_Vacunacion dtv = modelMapper.map(dtvDto, Detalle_Vacunacion.class);
        return dtv;
    }

    //El DTO setea los datos que fueron seteados en la ENTIDAD
    private Detalle_VacunacionDto mapearDto(Detalle_Vacunacion dtv) {
        Detalle_VacunacionDto dtvDto = modelMapper.map(dtv, Detalle_VacunacionDto.class);
        return dtvDto;
    }
    
}
