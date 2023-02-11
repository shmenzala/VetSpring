/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.service;

import com.pe.sh.Veterinaria.dto.ClienteDto;
import java.util.List;

/**
 *
 * @author shmen
 */
public interface ClienteService {
    
    public ClienteDto crearCliente(String codigope, ClienteDto cliDto);
    
    public List<ClienteDto> listarClientes();
    
    public ClienteDto obtenerClientePorId(String id, String codigope);
    
    public ClienteDto actualizarCliente(ClienteDto cliDto, String id, String codigope);
    
    public void eliminarCliente(String id, String codigope);
    
    //public List<ClienteDto> obtenerClientePorPersonaId(String id);
    
    public List<ClienteDto> listarClientesPorMascotaId(String codigoma);
    
}
